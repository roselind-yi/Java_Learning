package chapter08;

import java.io.IOException;
import java.net.*;

//还是需要在一个网络下
public class UDPClient {
    public static void main(String[] args) {
        //创建UDP协议的套接字
        try {
            //此处不需要指定端口，因为我们不用指定连接
            DatagramSocket datagram= new DatagramSocket();
            //准备发送数据
            String message="这是udp协议的测试数据。";
            byte[] data=message.getBytes();

            /*创建一个InetAdress地址对象,返回本机的ip地址
            getLocalHost()获取本机回环地址 【如果数据包发给自己】
            getByName("")获取一个具体的远程IP 【如果数据包发给远程】
            InetAddress address=InetAddress.getLocalHost();
            */
            InetAddress address=InetAddress.getByName("10.132.19.165");
            int port =1002;
            /*创建一个数据包，4个参数
            参数1：字节数组
            参数2：字节数组长度
            参数3：对方的IP
            参数4：对方的端口
            */

            //创建一个数据报
            DatagramPacket packet=new DatagramPacket(data,data.length,address,port);

            //用套接字发包
            //UDP协议的包不保证对方一定能收到
            //此时，若对方的ip不可达，或者对方的端口没有对外开放
            //udp协议的数据包会被丢弃
            datagram.send(packet);
            System.out.println("数据包发送成功！");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
