package com.chatroom.client.gui;

import com.chatroom.common.Constants;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * GUI 版消息接收线程：循环读取服务端消息并通过回调通知 UI
 */
public class GuiMessageReceiver implements Runnable {

    private final BufferedReader reader;
    private final MessageCallback callback;
    private volatile boolean running = true;

    public GuiMessageReceiver(BufferedReader reader, MessageCallback callback) {
        this.reader = reader;
        this.callback = callback;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            String message;
            while (running && (message = reader.readLine()) != null) {
                final String msg = message;
                // 判断消息类型
                if (msg.startsWith(Constants.SYSTEM_SENDER)) {
                    SwingUtilities.invokeLater(() -> callback.onSystemMessage(msg));
                } else {
                    SwingUtilities.invokeLater(() -> callback.onMessage(msg));
                }
            }
        } catch (IOException e) {
            // 服务端断开或网络异常
            if (running) {
                SwingUtilities.invokeLater(callback::onDisconnected);
            }
        }
    }
}
