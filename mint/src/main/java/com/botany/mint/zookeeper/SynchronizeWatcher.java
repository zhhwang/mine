package com.botany.mint.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class SynchronizeWatcher implements Watcher {
  private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

  public void create() throws Exception {
    ZooKeeper zk = new ZooKeeper("127.0.0.1: 2181", 3000, this);
    // 同步创建临时节点
    String path1 = zk.create("/zk-test-ephemeral1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
        CreateMode.EPHEMERAL);

    // 同步创建临时顺序节点
    String path2 = zk.create("/zk-test-emphemeral1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
        CreateMode.EPHEMERAL_SEQUENTIAL);

  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
      connectedSemaphore.countDown();
    }
  }
}
