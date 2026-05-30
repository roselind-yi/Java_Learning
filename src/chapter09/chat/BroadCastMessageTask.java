package chapter09.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * 实现接收客户端消息, 把消息广播给其他客户端
 */
public class BroadCastMessageTask implements Runnable{
    //当前客户端，由主线程传进来
    Socket socket;
        public BroadCastMessageTask(Socket socket){
            this.socket=socket;
    }

    @Override
    public void run() {
    //在子线程中读取当前客户短的信息
        //ObjectOutputStream out;
        ObjectInputStream in;
        try {
            //out= new ObjectOutputStream(socket.getOutputStream());
            //out.flush();//防止流的同步问题
            in=new ObjectInputStream(socket.getInputStream());
            while(true){
            //服务端反序列化客户端消息
                Message message=(Message)in.readObject();
                //把消息群发给其他客户端
                //遍历0-集合的size()
                for(int i=0;i<ChatServer.OUT_LIST.size();i++){
                    //取出集合中存储的每个客户端
                    ObjectOutputStream oos =ChatServer.OUT_LIST.get(i);
                    //拿到每个客户的输出流
                    oos.writeObject(message);
                    oos.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
