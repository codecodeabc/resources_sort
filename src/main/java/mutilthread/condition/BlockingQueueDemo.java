package mutilthread.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同一个锁支持创建多个Condition
 * <p>
 * 使用两个Condition来实现一个阻塞队列的例子
 */
public class BlockingQueueDemo<E> {

    int size;

    ReentrantLock lock = new ReentrantLock();

    LinkedList<E> list = new LinkedList<>();

    Condition notFull = lock.newCondition();

    Condition notEmpty = lock.newCondition();


    public BlockingQueueDemo(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size) {
                //队列已满，入队等待，等待可入队通知notFull.signal()
                notFull.await();
            }
            list.add(e);
            System.out.println("入队：" + e);
            // 可出队通知
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == 0) {
                // 队列为空，出队等待，等待可出队通知notEmpty.signal()
                notEmpty.await();
            }
            E peek = list.removeFirst();
            System.out.println("出队：" + peek);
            // 可入队通知
            notFull.signal();
            return peek;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueueDemo<Integer> queueDemo = new BlockingQueueDemo<>(2);
        int num = 10;
        for (int i = 0; i < num; i++) {
            int date = i;
            new Thread(() -> {
                try {
                    queueDemo.enqueue(date);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                try {
                    Integer dequeue = queueDemo.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
