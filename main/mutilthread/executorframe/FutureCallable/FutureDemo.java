package mutilthread.executorframe.FutureCallable;

import java.util.concurrent.*;

/**
 * Future获取线程执行结果
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 代码中创建了一个线程池，调用线程池的submit方法执行任务，submit参数为Callable接口：表示需要执行的任务有返回值，
         * submit方法返回一个Future对象，Future相当于一个凭证，可以在任意时间拿着这个凭证去获取对应任务的执行结果（调用其get方法），
         * 代码中调用了result.get()方法之后，此方法会阻塞当前线程直到任务执行结束
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",end!");
            return 10;
        });
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",结果：" + result.get());
    }
}
