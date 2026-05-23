package chapter08;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        //ServerSocket 服务端套接字类
        try {
        //创建一个服务端套接字对象，并监听系统1001端口
            ServerSocket server = new ServerSocket(1001);
            System.out.println("服务端套接字启动成功，监听1001号端口。");

        //接收（等待）【客服端的套接字】的连接
        //如果没有客户端接入，这行代码会一直阻塞进程，后面的代码暂停运行
        //返回客户端套接字对象
            Socket socket = server.accept();//阻塞服务端，等待传入
            System.out.println("有一个客户端接入成功！");

            //可以从套接字socket中获取到客户端的源IP和源端口信息
            System.out.println("远程端口："+socket.getPort());//这是一个随机端口
            System.out.println("本地端口："+socket.getLocalPort());

        //服务端如何接收客户端发送的数据
        //从socket套接字中获取一个输入流，用于读取客户端的输出
            InputStream is= socket.getInputStream();
        //创建缓冲区【字节数组】
            byte[] data= new byte[1024];

            //定义字节长度，-1表示末尾
            int len=is.read(data);
            String str=new String(data,0,len);
            System.out.println("詹收到客户端消息:"+str);

            //服务端如何给客户端回一条消息？
            OutputStream out=socket.getOutputStream();
            String back="这是詹这边返回的测试数据";
            out.write(back.getBytes());

            while(true){}

            //String str="";定义字符串变量接收客户端的消息

        /*while ((len=is.read(data))!=-1){
        //将缓冲区中字节编码为字符串
             str += new String (data,0,len);
        }*/


        //while(true){}//死循环不让退出，此处链接学习杀死进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// 我的：10.132.19.236
// 莎的：10.132.19.165