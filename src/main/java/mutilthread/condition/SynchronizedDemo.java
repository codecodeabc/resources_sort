package mutilthread.condition;


import java.util.concurrent.TimeUnit;

/**
 * synchronized中等待和唤醒线程示例
 */
public class SynchronizedDemo {

    static Object lock = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备获取锁");
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：成功获取锁");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：释放锁");
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：准备获取锁");
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：成功获取锁");
                //将t1线程从阻塞队列里移到同步队列，
                lock.notify();
                System.out.println(System.currentTimeMillis() + "," + this.getName() + "：notify T1线程");
                try {
                    //t2线程没放弃锁，所以是t2先走完同步代码
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + "," + this.getName() + "：释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }

}
