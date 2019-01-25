package com.botany.mint.jdk.socket.tcp.client;

import java.io.*;
import java.net.Socket;

/**
 * client endpoint
 * @author wangzh
 */
public class SocketDemo {

    private Socket socket;

    public SocketDemo() throws IOException {
        this.socket = new Socket("localhost", 9000);

       new Thread(() -> {
            try (InputStream in = socket.getInputStream();
                 InputStreamReader isr = new InputStreamReader(in, "utf-8");
                 BufferedReader br = new BufferedReader(isr)) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println(sb.toString());
            } catch (IOException e) {

            }
        }).start();

    }


    public void write(String data){
        try (OutputStream out = socket.getOutputStream()) {
            out.write(data.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            if (null != socket) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SocketDemo clientDemo = null;
        try {
            clientDemo = new SocketDemo();
            clientDemo.write("hello server socket");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientDemo != null) {
                clientDemo.close();
            }
        }
    }
}
