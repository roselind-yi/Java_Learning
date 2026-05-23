package chapter09;

public class Test01 {
    //主函数就是主线程
    //进程process，线程Thread
    //程序运行，启动一个Java进程
    //主函数：他是Java进程中的第一个线程【主线程，不需要我们创建】
    //子线程可以开启N个，【需要我们创建】
    public static void main(String[] args) {
        //子线程不可用独立运行，必须通过主函数创建运行
        CountThread ct1=new CountThread();
        ct1.setName("计数器线程1");

        //线程的启动方法，CPU分配一个新的处理单元run方法
        //注意：子线程的任务是写在run方法里面，而这里调用start方法

        ct1.start();//【并行】
        //start方法是父类写好的方法，在新的线程中运行run方法
        //但run方法是我们自己写的任务方法
        //如果直接在main主线程中调用run方法，这是一次普通方法调用，即会出现全是main的输出，只有一个线程，【串行】排队打印
        //ct1.run();

        //这里也写一个0-10000的打印
        for(int i=0;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);

        }

        CountThread ct2=new CountThread();
        ct2.setName("计数器线程2");

        ct2.run();
        //ct2.start();//到此，共有三个进程，1主2子

        //这里也写一个0-10000的打印
        for(int i=0;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);

        }

    }
}
