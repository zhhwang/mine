package com.botany.mint.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by wangzh on 17/10/19.
 */
public class ZookeeperClient {

  public void create() throws IOException {
    ZooKeeper zk = new ZooKeeper("127.0.0.1: 2181", 3000, null);
  }
}
