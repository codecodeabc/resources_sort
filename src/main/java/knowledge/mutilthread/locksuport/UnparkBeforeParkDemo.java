package knowledge.mutilthread.locksuport;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 调用唤醒unpark() 先于 阻塞 park() 案例效果
 * 线程会被唤醒
 */
public class UnparkBeforeParkDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + " start");
            // 如果 permit 为1时设置为 0，并立即返回
            // 如果  permit 为 0 ，则阻塞线程，知道unpark设置为1，所以本案例才能唤醒t1线程
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + " 唤醒线程t1");
        });
        thread.setName("t1");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        //每个线程都有一个许可(permit)，permit只有两个值1和0，默认是0。
        //此时unpark()把permit设置为 1
        LockSupport.unpark(thread);
        System.out.println(System.currentTimeMillis() + "unpark 执行完毕");
    }
}
