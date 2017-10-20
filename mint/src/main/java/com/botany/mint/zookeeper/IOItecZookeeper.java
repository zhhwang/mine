package com.botany.mint.zookeeper;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.server.ServerConfig;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class IOItecZookeeper {

    private ZkClient zkClient;
    private String configPath;
    private String serversPath;
    private ServerConfig serverConfig;
    private IZkDataListener dataListener;

    public IOItecZookeeper(String configPath, String serversPath, ZkClient zkClient, ServerConfig initConfig) {
        this.zkClient = zkClient;
        this.configPath = configPath;
        this.serversPath = serversPath;
        this.serverConfig = initConfig;
        this.dataListener = new IZkDataListener() {
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }

            @Override
            public void handleDataChange(String dataPath, Object data)
                    throws Exception {
                String retJson = new String((byte[]) data);
                ServerConfig serverConfigLocal = (ServerConfig) JSON.parseObject(retJson, ServerConfig.class);
                updateConfig(serverConfigLocal);
                System.out.println("new Work server config is:" + serverConfig.toString());
            }
        };
    }

    public void start() {
        System.out.println("work server start...");
        initRunning();
    }

    public void stop() {
        System.out.println("work server stop...");
        zkClient.unsubscribeDataChanges(configPath, dataListener);
    }

    private void initRunning() {
        registMe();
        zkClient.subscribeDataChanges(configPath, dataListener);
    }

    private void registMe() {
        String mePath = serversPath.concat("/").concat("serverAddress");

        try {
            zkClient.createEphemeral(mePath, "serverAddressKey".getBytes());
        } catch (Exception e) {
            zkClient.createPersistent(serversPath, true);
            registMe();
        }
    }

    private void updateConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
}
