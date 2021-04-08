package mutilthread.aqs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 根据AQS模板方法实现独占锁
 */
class Mutex implements Lock, java.io.Serializable {
    // Our internal helper class
    // 继承AQS的静态内存类
    // 重写方法
    private static class Sync extends AbstractQueuedSynchronizer {
        // Reports whether in locked state
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 根据AQS模板，独占锁需重写tryAcquire和tryRelease，实现同步状态的添加和释放

        /**
         * 锁状态判断，acquires设置为1则是加锁
         */
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;
            //判断当前是否为未加锁状态，未加锁则获取锁成功，
            //compareAndSetState进行一个比较更新，旧值如果是0，则更新成功并设置值为1
            if (compareAndSetState(0, 1)) {
                //设置占有锁的线程为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                //返回加锁成功
                return true;
            }
            return false;
        }

        /**
         * 锁状态的释放释放判断
         */
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            //当前无锁状态，释放锁成功，不成功则抛出异常
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition() {
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    // The sync object does all the hard work. We just forward to it.
    private final Sync sync = new Sync();
    //使用同步器的模板方法实现自己的同步语义
    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
