package com.chatroom.server;

import com.chatroom.common.Constants;

import java.io.*;
import java.net.Socket;

/**
 * 处理单个客户端连接：接收消息 → 广播给其他客户端
 */
public class ClientHandler implements Runnable {

    private final Socket socket;
    private String clientId;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.clientId = socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void run() {
        try (
                socket;
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), Constants.CHARSET));
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), Constants.CHARSET), true)
        ) {
            // 1. 接收客户端发来的昵称（首条消息）
            String firstMsg = reader.readLine();
            if (firstMsg == null) {
                return; // 客户端立即断开
            }
            // 昵称不能为空或与指令冲突
            if (firstMsg.isEmpty() || firstMsg.startsWith("/")) {
                clientId = "匿名用户-" + System.currentTimeMillis() % 10000;
            } else {
                clientId = firstMsg;
            }

            // 2. 注册到在线列表
            ClientManager.register(clientId, writer);
            System.out.println(clientId + " 已加入聊天室");
            ClientManager.broadcast(clientId, Constants.SYSTEM_SENDER + " " + clientId + " 进入了聊天室");

            String message;
            while ((message = reader.readLine()) != null) {
                // 过滤心跳消息
                if (Constants.HEARTBEAT.equals(message)) {
                    continue;
                }

                // 退出指令
                if (Constants.CMD_QUIT.equals(message)) {
                    break;
                }

                // 查看在线用户
                if (Constants.CMD_WHO.equals(message)) {
                    writer.println(Constants.SYSTEM_SENDER + " 在线用户：" + ClientManager.getOnlineUsers());
                    continue;
                }

                System.out.println("收到消息 [" + clientId + "]：" + message);
                // 广播消息给其他客户端
                ClientManager.broadcast(clientId, "[" + clientId + "]：" + message);
            }

        } catch (IOException e) {
            // 客户端异常断开（正常情况）
            System.out.println("客户端断开连接：" + clientId);
        } finally {
            // 清理资源 + 广播离开通知
            ClientManager.unregister(clientId);
            ClientManager.broadcast(clientId, Constants.SYSTEM_SENDER + " " + clientId + " 离开了聊天室");
            System.out.println(clientId + " 已离开聊天室");
        }
    }

    /**
     * 更新客户端 ID（用于后续昵称设置）
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
