package knowledge.jvm.gc;

/**
 * 长期存活的对象进入老年代
 *
 *  VM agrs: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1
 *
 */
public class LongTermSurvivalDemo {
    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB]; // 第一次gc  - eden区空间不足 触发GC
        allocation3 = null;               // 第二次gc  - 存在不可达对象 allocation3 触发GC ,allocation1 和 allocation2 会进入 老年代，from和to区为0%
        allocation3 = new byte[4 * _1MB];

        /**
         * allocation1在经过第一次GC时，对象年龄变成了1，由于设置的MaxTenuringThreshold=1，
         * 当发生第二次GC时，allocation1的年龄已经超出了设置的阀值，allocation1进入到老年代，因此，
         * 新生代的from space使用空间为0，对应GC语句为from space 1024K, 0% used
         */
    }

    public static void main(String[] agrs) {
        /**
         * 该段代码创建了3个数组对象，当执行到"allocation3 = new byte[4 * _1MB]; "时，Eden已经被占用了256KB + 4MB，
         * 而创建allocation3需要4MB，已经超过Eden的大小8MB，需要先发生一次MinorGC，才能保证有空间存放allocation3
         */
        testTenuringThreshold();
    }
}
