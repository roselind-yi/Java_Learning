package chapter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test04 {
    /**线程池工具Executors的使用
     * 简化线程池的创建，并且提供了四种默认的线程池
     * 虽然线程池工具类对线程池的创建做了简化，但是实际开发不建议使用
     * 只需要指定核心线程数1个参数即可，其他参数全部由工具方法帮我们配置
     * 《阿里巴巴开发手册》书中明确规定：生产环境禁止用工具类，工具类底层用的是无界队列！
     **/

    /**【创建固定线程池】：线程数固定不变，核心线程数=最大线程数**/
    ExecutorService pool1=Executors.newFixedThreadPool(5);
    /**【创建单线线程池】：线程中有且只有一个线程，线程死亡会自动补一个**/
    ExecutorService pool2=Executors.newSingleThreadExecutor();
    /**【创建可缓存线程池】：核心线程数的默认为0，最大线程数无上限，线程空闲60秒自动回收**/
    ExecutorService pool3=Executors.newCachedThreadPool();
    /**【创建定时任务线程池】：支持定时/周期执行**/
    ExecutorService pool4=Executors.newScheduledThreadPool(5);


}
