package mutilthread.limitflow;


import com.google.common.util.concurrent.RateLimiter;

/**
 * 使用令牌桶算法来进行限流
 *
 * https://mp.weixin.qq.com/s?__biz=MzA5MTkxMDQ4MQ==&mid=2648933212&idx=1&sn=b1e8f65d4673bd3cf64c2d6a00645ba9&chksm=88621b62bf15927422958029a1d240198082104d6e50d15dd33c5d3cf5af2195050b772782ec&token=870491352&lang=zh_CN#rd
 *
 * 令牌桶算法的原理是系统以恒定的速率产生令牌，然后把令牌放到令牌桶中，令牌桶有一个容量，
 * 当令牌桶满了的时候，再向其中放令牌，那么多余的令牌会被丢弃；当想要处理一个请求的时候，
 * 需要从令牌桶中取出一个令牌，如果此时令牌桶中没有令牌，那么则拒绝该请求。从原理上看，令
 * 牌桶算法和漏桶算法是相反的，一个“进水”，一个是“漏水”。这种算法可以应对突发程度的请求，因此比漏桶算法好。
 *
 *
 * Google开源工具包Guava提供了限流工具类RateLimiter，可以非常方便的控制系统每秒吞吐量，示例代码如下：
 */
public class TokenLimitDemo {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(5);//设置QPS为5
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
        System.out.println("----------");
        //可以随时调整速率，我们将qps调整为10
        rateLimiter.setRate(10);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }

        /**
         * 代码中RateLimiter.create(5)创建QPS为5的限流对象，
         * 后面又调用rateLimiter.setRate(10);将速率设为10，
         * 输出中分2段，第一段每次输出相隔200毫秒，第二段每次输出相隔100毫秒，
         * 可以非常精准的控制系统的QPS。
         */
    }

}
