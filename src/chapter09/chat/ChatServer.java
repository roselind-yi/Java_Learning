package chapter09.chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 聊天服务类
 */
public class ChatServer {
    /**
     * 用静态常量定义固定的值,
     * 服务端监听的端口,
     *核心线程数,
     *最大线程数,
     */
     private static final int PORT =8888;
     private static final int CORE_POOL_SIZE=Runtime.getRuntime().availableProcessors()*2;
     private  static final int MAXIMUM_POOL_SIZE=Runtime.getRuntime().availableProcessors()* 5;
    /**
     *空闲线程存活时间,
     *等待队列的容量,
     * 线程池,
     * 保存在线用户的集合
     */
     private static final int KEEP_ALIVE_TIME=60;
     private static final int QUEUE_CAPACITY=100;
     private static ThreadPoolExecutor threadPool;

     /**用动态数组保存在线用户的集合（防止重复创建）*/
     //static ArrayList<Socket> SOCKET_LIST=new ArrayList();

     /**用双向链表LinkedList也可以**/
    public static LinkedList<Socket> SOCKET_LIST=new LinkedList();
    public static LinkedList<ObjectOutputStream>OUT_LIST=new LinkedList<>();

    public static void main(String[] args) {
        //创建线程池
        threadPool =new ThreadPoolExecutor(
                CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );

    //启动服务端，监听指定端口
        try {
            ServerSocket server=new ServerSocket(PORT);
            //持续循环接入客户端连接
            while(true){//主线程循环迎接客户端socket
                //1.为客户分配任务
                Socket socket=server.accept();
                //2.将当前客户端保存到一个集合中
                OUT_LIST.add(new ObjectOutputStream(socket.getOutputStream()));//将他的流取出来放到动态数组中
                SOCKET_LIST.add(socket);//服务端接入多少个客户端
                //3.与客户分配任务
                BroadCastMessageTask task=new BroadCastMessageTask(socket);
                //4.将任务提交给线程池处理
                threadPool.execute(task);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
