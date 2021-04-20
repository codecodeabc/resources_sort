package mutilthread.unsafe;


import sun.misc.Unsafe;

import java.lang.reflect.Field;


/**
 * unsafe是单例对象，且构造函数是私有的，且内部getUnsafe()会判断如果不是系统类加载器加载的抛出异常SecurityException
 * 所以通过反射获取Unsafe对象
 */
public class GetUnsafeDemo {
    static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //Unsafe.getUnsafe()  会抛出异常SecurityException
        System.out.println(unsafe);
    }
}
