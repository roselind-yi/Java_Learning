package com.chatroom.server;

import com.chatroom.common.Constants;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端主入口：监听端口 + 线程池管理客户端连接
 */
public class ServerMain {

    public static void main(String[] args) {
        new ServerMain().start();
    }

    public void start() {
        System.out.println("===== 聊天室服务端启动 =====");
        try (ServerSocket serverSocket = new ServerSocket(Constants.DEFAULT_PORT)) {
            System.out.println("监听端口：" + Constants.DEFAULT_PORT + "，等待客户端连接...");

            // 注册关闭钩子，确保 JVM 退出时释放资源
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("\n服务端正在关闭...");
                ClientManager.shutdown();
            }));

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新客户端连接：" + socket.getRemoteSocketAddress());

                // 提交到线程池处理
                ClientHandler handler = new ClientHandler(socket);
                ClientManager.getThreadPool().execute(handler);
            }
        } catch (IOException e) {
            System.err.println("服务端异常：" + e.getMessage());
        }
    }
}
