package knowledge.mutilthread.executorframe.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Executors 的四种线程池
 */
public class ExecutorsPoolDemo {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
    }
}
