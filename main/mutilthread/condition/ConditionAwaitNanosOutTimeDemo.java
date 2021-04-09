package mutilthread.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * long awaitNanos(long nanosTimeout)超时返回
 */
public class ConditionAwaitNanosOutTimeDemo {

    static ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static class T1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "开始超时等待");
                long awaitNanos = condition.awaitNanos(TimeUnit.SECONDS.toNanos(5));
                System.out.println("超时等待返回时间："+ awaitNanos);
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "超时等待结束");
            } catch (InterruptedException e) {
                System.out.println("中断标志：" + this.isInterrupted());
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();
    }
}
