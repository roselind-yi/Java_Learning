package chapter08;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ObjectClient {
    public static void main(String[] args) {
        User user=new User("张三","男","数科","南邮通达",20);

        String host="10.132.19.165";
        int port =1004;
        try {
            Socket socket=new Socket(host,port);
            //客户端获取输出流(无传输对象的能力)
            OutputStream out=socket.getOutputStream();
            //包装增强一下, 对象流 (专门用于传输对象)
            ObjectOutputStream objout=new ObjectOutputStream(out);
            //用对象流传输对象
            objout.writeObject(user);

            //冲刷一下
            objout.flush();
            System.out.println("对象传输成功！~");
            //通知服务器传输结束。
            socket.shutdownOutput();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
