package com.botany.mint.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangzh on 17/10/19.
 */
public class AsynchronizeWatcher implements Watcher{
  private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

  public void create() throws Exception {
    ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 3000, this);

    zk.create("/zk-test-emphemeral1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new IStringCallback() , "I am a context.");
  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
      connectedSemaphore.countDown();
    }
  }

  class IStringCallback implements AsyncCallback.StringCallback {
    public void processResult(int rc, String path, Object ctx, String name) {
      System.out.println("Create path result: [" + rc +", " + path + "," + ctx+ ", real path name" + name + "]");
    }
  }
}
