package chapter08;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        //创建基于UDP协议的服务端套接字，监听端口
        //ServerSocket 这个类是基于TCP协议
        //DatagramSocket 这个类基于UDP协议
        try {
            DatagramSocket datagram=new DatagramSocket(1002);
            System.out.println("UDP服务器启动成功，监听1002窗口。");


            //UDP协议的服务器不需要等待客户端连接，直接等待接收数据
            //UDP协议不需要accept()操作

            //定义缓冲区
            byte[] data= new byte[1024];
            //创建数据报对象，用于接收UDP协议传输的数据
            DatagramPacket packet=new DatagramPacket(data,data.length);
            //从服务器套接字中接收数据报
            datagram.receive(packet);
            //解析数据报中收到的数据
            String message =new String (packet.getData(),0, packet.getLength());
            System.out.println("收到客户端的消息~"+message);


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
