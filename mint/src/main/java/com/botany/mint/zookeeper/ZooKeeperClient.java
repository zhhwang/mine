package com.botany.mint.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZooKeeperClient implements Watcher {

  public void create() throws Exception {
    ZooKeeper zk = new ZooKeeper("127.0.0.1: 2181", 3000, this);
    String path1 = zk.create("/zk-test-ephemeral1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
      System.out.print("同步处理");
    }
  }
}
