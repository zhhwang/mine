package com.botany.mint.jdk.socket.tcp.server.singlethreaded;

import java.nio.channels.ServerSocketChannel;

/**
 * @author wangzh
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        SingleThreadedServer server = new SingleThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
