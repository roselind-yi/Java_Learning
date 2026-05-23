package chapter09;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //饭店开业：端口地址为1000
            ServerSocket server=new ServerSocket(1000);
            //突发情况，来了个1000游客团！

            while(true){
                //主循环在这里循环迎接客人
                Socket socket=server.accept();
            //为每一个客人开辟一个子线程进行服务
                //创建子线程对象
                //启动子线程


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
