package chapter08;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
    public static void main(String[] args) {
        try {
            // 服务端套接字监听1004端口
            ServerSocket server=new ServerSocket(1004);
            // 等待客户端接入
            Socket socket=server.accept();
            // 从套接字获取基础字节输入流
            InputStream in=socket.getInputStream();
            // 包装增强一下 => 对象输入流
            ObjectInputStream objin=new ObjectInputStream(in);
            // 读取对象, 并向下转型为User 【对象类型还原】
            User user=(User) objin.readObject();

            System.out.println("对象接收成功！打印对象中携带反序列化信息~");
            System.out.println("姓名："+user.getName());
            System.out.println("性别："+user.getGender());
            System.out.println("学校："+user.getSchool());
            System.out.println("专业"+user.getSubject());
            System.out.println("年龄："+user.getAge());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
