package distributedLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class RedisLock {

    /**
     * 3秒超时时间
     */
    private long INTERNAL_LOCK_LEAST_TIME = 3;

    private String LOCK_KEY = "LOCK_KEY";

    /**
     * 设置set参数
     */
    private SetParams params = new SetParams().nx().px(INTERNAL_LOCK_LEAST_TIME);

    /**
     * 创建jedis连接
     */
    private static Jedis jedis = new JedisPool("127.0.0.1",6379).getResource();

    /**
     * 加锁
     */
    public boolean lock(String id){
        long start = System.currentTimeMillis();
        try {
            for(;;){
                String lock = jedis.set(LOCK_KEY, id, params);
                if("OK".equals(lock)){
                    return true;
                }
                long l = System.currentTimeMillis() - start;
                if(l >= INTERNAL_LOCK_LEAST_TIME){
                    return false;
                }
                ThreadLocalRandom current = ThreadLocalRandom.current();
                System.out.println(current.nextInt());
            }
        } finally {
            jedis.close();
        }
    }

    
}
