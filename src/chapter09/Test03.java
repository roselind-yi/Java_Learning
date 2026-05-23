package chapter09;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test03 {
    public static void main(String[] args) {

        /**【线程池核心参数：】（共有7个）面试必备！！！
         * //官方提供了一个线程池类
         1：参数名 corePoolSize,核心线程数，“饭店常备的服务员”，      就算空闲也不会销毁的
         2：参数名 maximumPoolSize，最大线程数，【50】            等待队列满了，线程数量扩容的上限
         3：参数名 keepAliveTime，空闲现成的存活时间，【60】        线程空闲多久会被销毁
         4：参数名 unit ，存活时间单位，【秒】                     时间单位可以是秒，或分
         5：参数名 workQueue,线程满了后的等待队列，【100】          核心线程满->队列->扩容
         6：参数名 threadFactory,线程工厂                        负责创建线程
         7：参数名 rejectHandler,拒绝策略                         核心线程满，队列满，最大线程满，触发拒绝
         影响缩容：3,4；影响扩容：5，6
         **/

        /**【线程池的执行流程】：面试必备！！！
         线程池启动 -> 一次性创建核心线程
         新的任务进来 -> 核心线程未满 -> 交给核心线程运行
         核心线程满了 -> 等待队列未满 -> 放入队列排队等待
         等待队列满了 -> 没有达到最大线程数 -> 创建新的线程执行
         最大线程也满了 -> 触发拒绝策略，
         **/

        /**对应七个核心参数的设置数额
        //Runtime.getRuntime()可以获取当前运行环境的信息
        //availableProcessors() 获取当前机器的cpu核心数
        //建议用cpu最大核心数 * 2 作为核心线程数 【通过超频技术1个核心可以虚拟出2个逻辑处理单位】
        //建议用cpu最大核心数 * 5 作为最大线程数 【cpu在多个线程之间交替切换，存在性能开销】
        //空闲存活时间：通常用60s
        //等待队列：分为有界队列+无界队列，建议用有界队列，例如设置有界队列队伍上限为100。
        //线程工厂，用官方提供的默认工厂即可
         **/

        /**【拒绝策略4】：面试必备！！！
         * 策略1：直接拒绝，并且抛出异常，让新的任务立即失效（默认策略，最安全的策略）
         * 策略2：让提交任务的线程自己处理（永不拒绝，温柔策略，不建议用，会拖慢主线程）
         * 策略3：沉默抛弃，拒绝但是不跑出异常
         * 策略4：抛弃队列中等待最久的，让新的任务进入队列等待。（也不建议使用）
         */

        int cpuCore=Runtime.getRuntime().availableProcessors();

        //创建一个有界队列,队列中存储Runnable接口的子类对象（即我们自己写的任务对象）【双向链表】
        ArrayBlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(100);

        ThreadPoolExecutor threadpool=new ThreadPoolExecutor(
                //参数1，2，3，4，5是必须的
                cpuCore *2,
                cpuCore*5,
                60,
                TimeUnit.SECONDS,
                queue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
