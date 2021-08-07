package knowledge.mutilthread.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDome {

    public static void main(String[] args) {
        //单线程offer
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer(1);
    }
}
