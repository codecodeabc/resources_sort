package mutilthread.locksuport;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 演示LockSupport.park() 被 中断 后运行结果案例
 */
public class ParkByInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start");
            System.out.println(Thread.currentThread().getName() + " 中断前标志" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 中断后标志" + Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end");
        });
        thread.setName("T1");
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        //中断唤醒park() 阻塞的线程
        thread.interrupt();
    }
}
