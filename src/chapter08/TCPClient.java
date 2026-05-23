package chapter08;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {

    /**定义目标ip,目标端口
    //如果目标是本机（自己连接自己），可以写本机回环地址（localhost127.0.0.1）
    //如果目标是其他机器，必须写对方的真实IP
     **/
        String host="10.132.19.236";

        int port=1001;

    //创建客服端的套接字对象socket
    //这一行代码就是建立【端-端】的网络连接
        try {
    //客户端socket创建成功后，服务端会解除accept()阻塞等待
    //此时就可以通过客户端的socket与服务端的socket进行数据传输
    // 对应服务端的server.accept();
            Socket socket=new Socket(host,port);
            System.out.println("连接成功！");
            System.out.println("远程端口："+socket.getPort());//地址是对调关系。
            System.out.println("本地端口："+socket.getLocalPort());

    //客户端如何给服务端发送信息？
    //从客户端套接字对象socket中获取输出流【插入网络的流】【插入到磁盘的流】
            OutputStream out=socket.getOutputStream();
            String str ="这是一条詹的测试数据。";
            //out.write(str);字节流无法处理字符串
            out.write(str.getBytes());//先调用,不用flush，这是字节流。

            //客户端接收服务端返回的消息
            InputStream is= socket.getInputStream();
            byte[] data=new byte[1024];
            int len=is.read(data);
            String back=new String(data,0,len);
            System.out.println("詹服务端返回消息："+back);


        } catch (IOException e) {
    //Connection tiemout 连接超时，默认15s，原因：IP寻址失败
    //Connection refused 连接被拒绝，2s后，原因：对方的通信端口未打开。
            throw new RuntimeException(e);
        }
    }
}
