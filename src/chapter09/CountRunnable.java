package chapter09;

public class CountRunnable implements Runnable{
    /**接口和父类的区别
    //继承父类关键字extends
    //继承接口关键字用implements
    //因为java的主类只支持单继承，只能被一个类继承
    **/

    @Override
    public void run() {
        for(int i=0;i<=10000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}
