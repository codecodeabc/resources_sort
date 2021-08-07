package knowledge.mutilthread.locksuport;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  演示Condition实现线程等待/通知前没获取锁
 */
public class ConditionNoGetLockDome {
    static ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "开始等待");
                condition.await();
                System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + "结束等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        condition.signal();
    }
}
