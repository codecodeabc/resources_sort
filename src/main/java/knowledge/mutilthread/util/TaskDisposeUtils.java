package knowledge.mutilthread.util;


import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 利用线程池和CoundownLatch实现得任务并行处理工具类
 */
public class TaskDisposeUtils {

    //并行线程数

    public static final int POOL_SIZE;

    static {
        POOL_SIZE = Integer.max(Runtime.getRuntime().availableProcessors(),5);
    }

    /**
     * 线程提交执行
     * @param taskList   参数列表
     * @param consumer   线程执行过程-消费者
     * @throws InterruptedException
     */
    public static <T> void dispose(List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        dispose(true,POOL_SIZE,taskList,consumer);
    }

    private static <T> void dispose(boolean moreThread, int poolSize, List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        if(taskList.isEmpty()){
            return;
        }
        if(moreThread && poolSize > 1){
            poolSize = Math.min(poolSize, taskList.size());
            ExecutorService executorService = null;
            try {
                executorService = Executors.newFixedThreadPool(poolSize);
                CountDownLatch countDownLatch = new CountDownLatch(taskList.size());
                for(T item : taskList){
                    executorService.execute(()->{
                        try {
                            consumer.accept(item);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                countDownLatch.await();
            } finally {
                if(executorService != null){
                    executorService.shutdown();
                }
            }
        }else {
            for(T item:taskList){
                consumer.accept(item);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList());
        long startTimeOut = System.currentTimeMillis();
        //提交参数列表，和线程执行过程
        TaskDisposeUtils.dispose(list,item ->{
            try {
                long startTime = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(item);
                long endTime = System.currentTimeMillis();
                System.out.println(System.currentTimeMillis() + ", 任务" + item + "执行完毕，耗时：" + (endTime - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endTimeOut = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTimeOut - startTimeOut));
        System.out.println(list + "中任务都执行完毕");
    }
}
