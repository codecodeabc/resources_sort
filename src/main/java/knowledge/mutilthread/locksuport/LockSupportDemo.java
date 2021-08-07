package knowledge.mutilthread.locksuport;

import java.util.concurrent.locks.LockSupport;

/**
 * lockSupport基本使用
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() +" : 线程被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("准备唤醒线程。。");
        LockSupport.unpark(thread);
    }
}
