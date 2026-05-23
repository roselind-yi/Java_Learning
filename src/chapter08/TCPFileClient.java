package chapter08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//基于TCP的文件传输
public class TCPFileClient {
    public static void main(String[] args) {
       String host="10.132.19.165";
       int port=1003;
        try {
            Socket socket=new Socket(host,port);
            // 客户端: 磁盘文件 - 内存缓冲区 - 网卡
            // 服务端: 网卡 - 内存缓冲区 - 磁盘文件
            String path="C:\\Users\\123\\Pictures\\Camera Roll\\Saved Pictures\\WIN_20241129_17_10_41_Pro.mp4";
            //内存读磁盘的基础字节输入流
            InputStream in=new FileInputStream(path);
            //包装增强一下
            BufferedInputStream bufin=new BufferedInputStream(in);
            //内存写入到网络的基础字节输入流，从套接字中获取
            OutputStream out=socket.getOutputStream();
            //包装增强一下
            BufferedOutputStream bufout=new BufferedOutputStream(out);
            //内存缓冲区
            byte[]  data=new byte[1024*128];
            int len;
            //循环读写
            while((len=bufin.read(data))!=-1){
                bufout.write(data,0,len);
            }
            //冲刷一下，防止残留数据
            bufout.flush();
            System.out.println("文件传输完成！");

            // 客户端文件传输结束后, 要通知一下服务端输出结束
            // 否则服务端循环还是傻傻的等待客户端继续传数据, 导致服务端报错
            socket.shutdownOutput();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
