package knowledge.mutilthread.semaphore;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 比如有个停车场，有5个空位，门口有个门卫，手中5把钥匙分别对应5个车位上面的锁，来一辆车，门卫会给司机一把钥匙，
 * 然后进去找到对应的车位停下来，出去的时候司机将钥匙归还给门卫。停车场生意比较好，同时来了100两车，门卫手中只有5把钥匙，
 * 同时只能放5辆车进入，其他车只能等待，等有人将钥匙归还给门卫之后，才能让其他车辆进入。
 * <p>
 * 上面的例子中门卫就相当于Semaphore，车钥匙就相当于许可证，车就相当于线程。
 */
public class SemaphoreLimitFow {

    //创建信号量，相当于车位
    static Semaphore semaphore = new Semaphore(2);

    //创建车辆线程
    public static class T extends Thread {
        public T(String name) {
            super(name);
        }
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + "  " + thread.getName() + " 车辆已入库");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(System.currentTimeMillis() + "  " + thread.getName() + " 车辆出库");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        for (int i = 0; i < num; i++) {
            T t = new T("A" + i);
            t.start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
