package knowledge.mutilthread.createthread;

import java.util.concurrent.*;

public class FristType {
    public static void main(String[] args) {

        //第一种
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };

        thread.start();

        //第二种
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });
        thread1.start();


        //第三种
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                poolSize,
                poolSize,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(poolSize * 1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            Future<Object> future = poolExecutor.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    return "poolexecutor call thread";
                }
            });

            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
