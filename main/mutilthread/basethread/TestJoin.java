package mutilthread.basethread;

/**
 * 测试join方法
 */
public class TestJoin {
    public static void main(String[] args) {
        //
        Thread threadA = new Thread() {
            @Override
            public void run() {
                System.out.print("A  ");

            }
        };


        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    //B线程要等A线程结束才执行，所以会先输出 A B
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        };
        //先启动B线程,再启动B线程，
        threadB.start();
        threadA.start();

    }
}
