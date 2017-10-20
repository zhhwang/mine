package com.botany.mint.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class ZookeeperClientTest implements Watcher{

    private ZooKeeper zk = null;

    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    @Before
    public void connect() {
        this.closeConnection();
        try {
            zk = new ZooKeeper("127.0.0.1:2181", 3000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void watcherTest() {
        try {
            String path = "/zk-test-ephemeral";
            zk.create(path , "before".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

            zk.getData(path, new PathWatcher(), null);
            zk.setData(path, "after".getBytes(), -1);

            this.closeConnection();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if (null != zk) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState())
            connectedSemaphore.countDown();
    }

    class PathWatcher implements Watcher{
        @Override
        public void process(WatchedEvent watchedEvent) {
            try {
                if (Event.EventType.NodeDataChanged == watchedEvent.getType()) {
                    System.out.println("节点数据/zk-test-ephemeral更新为：" + new String(zk.getData("/zk-test-ephemeral", false, null)));
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
