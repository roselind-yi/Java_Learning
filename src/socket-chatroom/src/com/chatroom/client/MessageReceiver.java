package com.chatroom.client;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 客户端接收线程：循环读取服务端转发来的消息并打印到控制台
 */
public class MessageReceiver implements Runnable {

    private final BufferedReader reader;
    private final ClientMain client;

    public MessageReceiver(BufferedReader reader, ClientMain client) {
        this.reader = reader;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            String message;
            while (client.isRunning() && (message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            // 服务端断开或网络异常
            if (client.isRunning()) {
                System.out.println("\n与服务端的连接已断开。");
            }
        } finally {
            client.shutdown();
        }
    }
}
