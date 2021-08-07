package knowledge.mutilthread.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * condition实现两个线程 -等待与通知  --路人甲
 */
public class ConditionLuRenJiaDemo {


    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备获取锁");
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：成功获取锁");
                condition.await();
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：释放锁");
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备获取锁");
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：成功获取锁");
                //将t1线程从阻塞队列里移到同步队列，
                condition.signal();
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：notify T1线程");
                //t2线程没放弃锁，所以是t2先走完同步代码
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备释放锁");
            } finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }


}
