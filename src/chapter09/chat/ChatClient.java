package chapter09.chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        // 服务端的IP和端口 = 饭店的地址
        String host = "192.168.1.183";
        int port = 8888;
        // 客户端连接服务端
        try {
            // 连接服务端
            Socket socket = new Socket(host, port);
            // 客户端子线程负责接收消息
            ReceiveMessageTask task = new ReceiveMessageTask(socket);
            // 自己创建一个线程 (客户端只有一个子线程, 无需用线程池)
            Thread t = new Thread(task);
            t.start();

            // 客户端主线程负责发送消息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入你的用户名:");
            String username = scanner.next();
            // 主线程循环发送消息
            while (true) {
                System.out.println("请输入你的发送的内容:");
                String content = scanner.next();
                // 创建消息对象
                Message message = new Message(username, content);
                // 用对象输出流进行消息的序列化
                oos.writeObject(message);
                // 冲刷一下流
                oos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}