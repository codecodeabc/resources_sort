package mutilthread.aqs;


import java.util.concurrent.TimeUnit;

/**
 * 测试继承AQS实现同步组件Mutex
 */
public class AQSDome {

    private static Mutex mutex = new Mutex();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                try {
                    mutex.tryLock(1000, TimeUnit.MILLISECONDS);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutex.unlock();
                }
            });
            thread.start();
        }
    }

}
