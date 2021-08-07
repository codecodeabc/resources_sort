package knowledge.mutilthread.countdownlatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *  CountDownLatch 验证多线程执行结束等待，
 */
public class CountDownLatchDemo {

    public static class T extends Thread{

        //休眠时间
        int sleepSeconds;

        CountDownLatch countDownLatch;

        public T(String name,int sleepSeconds,CountDownLatch countDownLatch) {
            super(name);
            this.sleepSeconds = sleepSeconds;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                System.out.println(System.currentTimeMillis() + " " + thread.getName() + " 线程开始运行" );
                //休眠
                TimeUnit.SECONDS.sleep(this.sleepSeconds);
                System.out.println(System.currentTimeMillis() + " " + thread.getName() + " 运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //线程运行结束，等待数量减一
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long start = System.currentTimeMillis();
        T t1 = new T("t1",4,countDownLatch);
        t1.start();
        TimeUnit.SECONDS.sleep(1);

        T t2 = new T("t2",2,countDownLatch);
        t2.start();
        TimeUnit.SECONDS.sleep(1);

        //通过线程等待依赖
        countDownLatch.await();

        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " end");
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));
    }
}
