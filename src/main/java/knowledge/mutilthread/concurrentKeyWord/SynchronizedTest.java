package knowledge.mutilthread.concurrentKeyWord;


/**
 * 测试synchronized关键字
 */
public class SynchronizedTest implements Runnable{

    private static int count  = 0;

    @Override
    public void run() {
        //添加类锁，每次只能一个线程访问该代码块
        synchronized (SynchronizedTest.class) {
            for(int i = 0;i<100000;i++){
                count++;
            }
            //由输出的线程名可见，创建线程后线程是竞争获取锁，不是顺序获取锁
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            Thread thread = new Thread(new SynchronizedTest(),"thread-"+i);
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(SynchronizedTest.count);
    }
}
