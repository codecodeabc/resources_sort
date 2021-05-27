package mutilthread.countdownlatch;



import java.util.concurrent.TimeUnit;

/**
 * 演示主线程等待其他线程
 */
public class SimpleJoinDemo {


    public static class T extends Thread{

        //休眠时间
        int sleepSeconds;

        public T(String name,int sleepSeconds) {
            super(name);
            this.sleepSeconds = sleepSeconds;
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
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        T t1 = new T("t1",4);
        t1.start();
        TimeUnit.SECONDS.sleep(1);

        T t2 = new T("t2",2);
        t2.start();
        TimeUnit.SECONDS.sleep(1);

        //通过线程等待依赖
        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));
    }
}
