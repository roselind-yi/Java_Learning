package chapter09.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端接收消息的任务类
 */
public class ReceiveMessageTask implements Runnable{
    Socket socket;
    // 通过构造函数将主线程中socket传递到子线程中
    public ReceiveMessageTask(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 获取输出流
            //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //out.flush();
            // 获取输入流
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // 循环读取服务端的消息 (服务端不会主动发信息, 但是会转发其他人的消息)
            while (true) {
                // 读取消息, 并进行反序列化
                Message message = (Message) in.readObject();
                // 打印消息:
                System.out.println("收到一条新的消息:");
                System.out.println("发送人:" + message.getUsername());
                System.out.println("发送时间:" + message.getSendTime());
                System.out.println("消息内容:" + message.getContent());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}