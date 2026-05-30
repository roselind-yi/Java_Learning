package com.chatroom.client;

import com.chatroom.common.Constants;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端主入口：连接服务端，启动收发双线程
 */
public class ClientMain {

    private final String host;
    private final int port;
    private String nickname;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private volatile boolean running = true;

    public ClientMain(String host, int port, String nickname) {
        this.host = host;
        this.port = port;
        this.nickname = nickname;
    }

    public static void main(String[] args) {
        // 如果通过命令行参数传了昵称则直接用，否则提示用户输入
        String nickname = args.length > 0 ? args[0] : null;
        ClientMain client = new ClientMain(Constants.DEFAULT_HOST, Constants.DEFAULT_PORT, nickname);
        client.start();
    }

    public void start() {
        try {
            // 1. 连接服务端
            socket = new Socket(host, port);
            writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), Constants.CHARSET), true);
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), Constants.CHARSET));

            // 2. 输入昵称并发送（首条消息作为身份标识）
            Scanner scanner = new Scanner(System.in);
            if (nickname == null || nickname.isEmpty()) {
                System.out.print("请输入您的昵称：");
                System.out.flush(); // 确保 IDEA 控制台能立即显示
                nickname = scanner.nextLine().trim();
                if (nickname.isEmpty()) {
                    nickname = "匿名用户";
                }
            } else {
                System.out.println("使用昵称：" + nickname);
            }
            writer.println(nickname);

            System.out.println("===== 欢迎来到聊天室！=====");
            System.out.println("昵称：" + nickname);
            System.out.println("输入消息直接发送，输入 " + Constants.CMD_QUIT + " 退出，输入 " + Constants.CMD_WHO + " 查看在线用户");
            System.out.println("===============================");

            // 3. 启动接收线程
            Thread receiver = new Thread(new MessageReceiver(reader, this));
            receiver.setDaemon(true);
            receiver.start();

            // 4. 主线程负责发送（读取控制台输入）
            while (running && scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                }
                writer.println(input);

                if (Constants.CMD_QUIT.equals(input)) {
                    running = false;
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("连接服务端失败：" + e.getMessage());
        } finally {
            shutdown();
        }
    }

    /**
     * 关闭客户端连接
     */
    public void shutdown() {
        running = false;
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ignored) {
        }
        System.out.println("已退出聊天室。");
    }

    public boolean isRunning() {
        return running;
    }
}
