package knowledge.mutilthread.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义连接池
 */
public class CustomDefinitionPoolDome {

    static AtomicInteger threadNum = new AtomicInteger(1);

    public static void main(String[] args) {
        /**
         * 给线程池中线程起一个有意义的名字，在系统出现问题的时候，通过线程堆栈信息可以更容易发现系统中问题所在。
         * 自定义创建工厂需要实现java.util.concurrent.ThreadFactory接口中的Thread newThread(Runnable r)方法，
         * 参数为传入的任务，需要返回一个工作线程。
         */
        //实现ThreadFactory ,由于ThreadFactory只有一个方法，所以使用Lambda表达式实现
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), r -> {
            Thread thread = new Thread(r);
            thread.setName("自定义线程-" + threadNum.getAndIncrement());
            return thread;
        });
        for (int i = 0; i < 5; i++) {
            String taskName = "任务-" + i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "处理" + taskName);
            });
        }
        executor.shutdown();
    }
}
