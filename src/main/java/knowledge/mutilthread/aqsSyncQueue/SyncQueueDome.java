package knowledge.mutilthread.aqsSyncQueue;


import java.util.concurrent.locks.ReentrantLock;

/**
 * debug测试AQS静态内部类Node的同步队列
 */
public class SyncQueueDome {


    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5 ;i++){
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }


}
