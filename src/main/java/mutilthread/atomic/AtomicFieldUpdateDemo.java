package mutilthread.atomic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 原子的操作 对象的属性 案例 - 使用 对象的属性修改原子类 的更新器来更新修改
 *
 */
public class AtomicFieldUpdateDemo {


    static AtomicFieldUpdateDemo demo5 = new AtomicFieldUpdateDemo();
    //isInit用来标注是否被初始化过
    volatile Boolean isInit = Boolean.FALSE;
    //通过 AtomicReferenceFieldUpdater 获取更新器
    AtomicReferenceFieldUpdater<AtomicFieldUpdateDemo, Boolean> updater = AtomicReferenceFieldUpdater.newUpdater(AtomicFieldUpdateDemo.class, Boolean.class, "isInit");

    /**
     * 模拟初始化工作
     *
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {
        //isInit为false的时候，才进行初始化，并将isInit采用原子操作置为true，使用更新器来更新属性
        if (updater.compareAndSet(demo5, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，开始初始化!");
            //模拟休眠3秒
            TimeUnit.SECONDS.sleep(3);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，初始化完毕!");
        } else {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，有其他线程已经执行了初始化!");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    demo5.init();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
