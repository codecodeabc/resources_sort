package mutilthread.basethread;


/**
 * 测试线程中断interrupted
 */
public class TestInterrupted {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    sleep(10000);
                    //由于被中断，sleep会抛出异常，导致2没有输出
                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果放在这里，中断异常抛出后被上面捕获，这里还是会执行
                System.out.println(3);
            }
        };
        thread.start();

        //当线程使用wait() / sleep() /join() 都会抛出中断异常
        thread.interrupt();

        //输出线程是否被中断
        System.out.println(thread.isInterrupted());
    }
}
