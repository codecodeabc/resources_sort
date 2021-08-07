package knowledge.mutilthread.basethread;

/**
 * 测试stop方法
 */
public class TestStop {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
                stop();
                System.out.println(2);
            }
        };

        thread.start();
    }
}
