package mutilthread.executorframe.scheduledExecutorService;


import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定的频率执行任务
 */
public class ScheduleAtFixedRateDemo {

    /**
     * 4个参数：
     *
     * command：表示要执行的任务
     *
     * initialDelay：表示延迟多久执行第一次
     *
     * period：连续执行之间的时间间隔
     *
     * unit：参数2和参数3的时间单位，是个枚举，可以是天、小时、分钟、秒、毫秒、纳秒等
     *
     *
     * 假设系统调用scheduleAtFixedRate的时间是T1，那么执行时间如下：
     *
     * 第1次：T1+initialDelay
     *
     * 第2次：T1+initialDelay+period
     *
     * 第3次：T1+initialDelay+2*period
     *
     * 第n次：T1+initialDelay+(n-1)*period
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            int currCount = count.getAndIncrement();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "执行结束");
        }, 1, 1, TimeUnit.SECONDS);
    }
}
