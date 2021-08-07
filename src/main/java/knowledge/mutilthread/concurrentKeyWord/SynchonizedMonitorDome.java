package knowledge.mutilthread.concurrentKeyWord;


/**
 * 测试 SynchonizedMonitor 实质 - monitor
 */
public class SynchonizedMonitorDome {

    private static volatile String test = "666";

    public static void main(String[] args) {
        //代码块添加类锁，当前线程，即main现在获取到锁后
        synchronized (SynchonizedMonitorDome.class){
        }
        //再执行该代码时，也是要获取锁，由于synchonized是可重入锁，所以只有一个monitorenter
        /**
         *          0: ldc           #2                  // class knowledge.mutilthread/concurrentKeyWord/SynchonizedMonitorDome
         *          2: dup
         *          3: astore_1
         *          4: monitorenter
         *          5: aload_1
         *          6: monitorexit
         *          7: goto          15
         *         10: astore_2
         *         11: aload_1
         *         12: monitorexit
         */
        mothed();
        test = "777";
    }

    private static void mothed(){

        
    }
}
