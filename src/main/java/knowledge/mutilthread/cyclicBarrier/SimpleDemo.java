package knowledge.mutilthread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier 循环屏障的基本使用-类似CountDownLatch的计数器
 * <p>
 * 代码中模拟了10个员工上桌吃饭的场景，等待所有员工都到齐了才能开发，当10个员工都调用了cyclicBarrier.await();之后，所有处于等待中的员工都会被唤醒，然后继续运行。
 */
public class SimpleDemo {

    //创建循环屏障对象
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static class T extends Thread {

        //休眠时间
        int sleepSeconds;

        CountDownLatch countDownLatch;

        public T(String name, int sleepSeconds) {
            super(name);
            this.sleepSeconds = sleepSeconds;

        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                TimeUnit.SECONDS.sleep(sleepSeconds);
                long starTime = System.currentTimeMillis();
                //调用await()的时候，当前线程将会被阻塞，需要等待其他员工都到达await了才能继续
                cyclicBarrier.await();
                long endTime = System.currentTimeMillis();
                System.out.println(this.getName() + ",sleep:" + this.sleepSeconds + " 等待了" + (endTime - starTime) + "(ms),开始吃饭了！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new T("员工" + i, i).start();
        }
    }
}
