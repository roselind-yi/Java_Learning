package chapter09;

public class Test02 {
    public static void main(String[] args) {
        //创建任务对象
        CountRunnable cr = new CountRunnable();
        //继承接口的对象，没有start()方法
        Thread t1 = new Thread(cr, "计数器子线程1");
        Thread t2 = new Thread(cr, "计数器子线程2");
        t1.start();
        t2.start();
    //这种情况也是并行运行
        for (int i = 0; i <= 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);


        }
    }
}
