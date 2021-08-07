package knowledge.mutilthread.limitflow;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 限流方法：通过控制最大并发数来进行限流
 * <p>
 * 以秒杀业务为例，10个iphone，100万人抢购，100万人同时发起请求，最终能够抢到的人也就是前面几个人，后面的基本上都没有希望了，
 * 那么我们可以通过控制并发数来实现，比如并发数控制在10个，其他超过并发数的请求全部拒绝，提示：秒杀失败，请稍后重试。
 * <p>
 * 并发控制的，通俗解释：一大波人去商场购物，必须经过一个门口，门口有个门卫，兜里面有指定数量的门禁卡，来的人先去门卫那边拿取门禁卡，
 * 拿到卡的人才可以刷卡进入商场，拿不到的可以继续等待。进去的人出来之后会把卡归还给门卫，门卫可以把归还来的卡继续发放给其他排队的顾客使用。
 */
public class ConcurrentMaxNumDemo {

    static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++){

            new Thread(()->{
                boolean b = false;
                try {
                    //尝试获取一个凭证，超时返回
                    b = semaphore.tryAcquire(100, TimeUnit.MILLISECONDS);
                    if(b){
                        System.out.println("获取成功。。。");
                        TimeUnit.SECONDS.sleep(2);
                    }else{
                        System.out.println("获取失败。。。。");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(b){
                        semaphore.release();
                    }
                }
            }).start();

        }
        Thread.currentThread().join();
    }
}
