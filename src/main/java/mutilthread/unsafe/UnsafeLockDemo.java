package mutilthread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * unsafe 锁示例
 *
 * monitorEnter、monitorExit、tryMonitorEnter 3个方法已过期，不建议使用了
 *
 * monitorEnter、monitorExit必须成对出现，出现的次数必须一致，也就是说锁了n次，也必须释放n次，否则会造成死锁
 */
public class UnsafeLockDemo {
    static Unsafe unsafe;
    //用来记录网站访问量，每次访问+1
    static int count;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //模拟访问一次
    public static void request() {
        unsafe.monitorEnter(UnsafeLockDemo.class);
        try {
            count++;
        } finally {
            unsafe.monitorExit(UnsafeLockDemo.class);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "，耗时：" + (endTime - starTime) + ",count=" + count);
    }
}
