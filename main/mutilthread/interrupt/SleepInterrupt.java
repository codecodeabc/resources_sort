package mutilthread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 测试中断阻塞线程
 */
public class SleepInterrupt {

    public static class T extends Thread {
        @Override
        public void run() {
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupt();
                }
                if(this.isInterrupted()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }
}
