package chapter09;


public class CountThread extends Thread{
    @Override
    public void run() {
        //任务：用for循环打印1-10000
        for(int i=0;i<=10000;i++){
            //获取当前线程的名字
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}
