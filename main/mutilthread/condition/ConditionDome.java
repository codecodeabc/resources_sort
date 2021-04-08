package mutilthread.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Condition等待await()与通知signal()/signalAll()
 */
public class ConditionDome {

    /**
     * 创建锁
     */
    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 创建对应锁的condition等待通知
     */
    private static Condition condition = lock.newCondition();

    /**
     * 创建变量判断,volotile 线程之前可见
     */
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(new waiter());
        waiter.start();
        Thread signal = new Thread(new signal());
        signal.start();
    }

    //创建等待线程
    static class waiter implements Runnable {
        @Override
        public void run() {
            //获取锁
            lock.lock();
            try {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + ": 当前线程不满住条件");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": 当前线程满足条件-Running");
            } finally {
                lock.unlock();
            }
        }
    }

    //创建通知线程
    static class signal implements Runnable {
        @Override
        public void run() {
            //获取锁
            lock.lock();
            try {
                flag = true;
                //唤醒一个等待队列里的第一个线程
                condition.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
