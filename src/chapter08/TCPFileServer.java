package chapter08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(1003);
            Socket socket=server.accept();

            InputStream in=socket.getInputStream();
            String path = "D:/test.mp4";
            //增强字节流（传网络文件比基础的字节流性能更优）
            BufferedInputStream bufin=new BufferedInputStream(in);

            //获取磁盘文件的输出流
            OutputStream out=new FileOutputStream(path);

            //增强
            BufferedOutputStream bufout=new BufferedOutputStream(out);

            //内存缓冲区
            byte[] data=new byte[1024*128];
            int len;//字节长度
            //循环读写。用内存缓冲区作为数据中转
            while((len=bufin.read(data))!=-1){
                bufout.write(data,0,len);
            }
            System.out.println("文件接收成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
