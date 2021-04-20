package mutilthread.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ABA问题：
 * 之前我们说过，线程判断被修改对象是否可以正确写入的条件是对象的当
 * 前值和期望值是否一致。这个逻辑从一般意义上来说是正确的，但是可能出现一个小小的例外，
 * 就是当你获得当前数据后，在准备修改为新值钱，对象的值被其他线程连续修改了两次，而经过这2次修改后，
 * 对象的值又恢复为旧值，这样，当前线程就无法正确判断这个对象究竟是否被修改过，这就是所谓的ABA问题，可能会引发一些问题。
 *
 * 案例：
 * 有一家蛋糕店，为了挽留客户，决定为贵宾卡客户一次性赠送20元，刺激客户充值和消费，但条件是，每一位客户只能被赠送一次，现在我们用AtomicReference来实现这个功能，
 */
public class ABADemo {


    //账户原始余额
    static int accountMoney = 19;
    //用于对账户余额做原子操作
    static AtomicReference<Integer> money = new AtomicReference<>(accountMoney);

    /**
     * 模拟2个线程同时更新后台数据库，为用户充值
     */
    static void recharge() {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    Integer m = money.get();
                    if (m == accountMoney) {
                        if (money.compareAndSet(m, m + 20)) {
                            System.out.println("当前余额：" + m + "，小于20，充值20元成功，余额：" + money.get() + "元");
                        }
                    }
                    //休眠100ms
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 模拟用户消费
     */
    static void consume() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Integer m = money.get();
            if (m > 20) {
                if (money.compareAndSet(m, m - 20)) {
                    System.out.println("当前余额：" + m + "，大于10，成功消费10元，余额：" + money.get() + "元");
                }
            }
            //休眠50ms
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        recharge();
        consume();

        /**
         * 从输出中可以看到，这个账户被先后反复多次充值。其原因是账户余额被反复修改，修改后的值和原有的数值19一样，
         * 使得CAS操作无法正确判断当前数据是否被修改过（是否被加过20）。虽然这种情况出现的概率不大，但是依然是有可能出现的，
         * 因此，当业务上确实可能出现这种情况时，我们必须多加防范。JDK也为我们考虑到了这种情况，使用AtomicStampedReference可以很好地解决这个问题。
         */
    }
}
