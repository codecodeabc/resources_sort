package design.proxy.cglibproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class CglibMain {
    public static void main(String[] args) {
        simpleHandler();
        multiHandler();
    }

    /**
     * 单个处理器
     */
    private static void simpleHandler() {
        Enhancer enhancer = new Enhancer();
        // 设置超类，cglib是通过继承来实现的
        enhancer.setSuperclass(UserDao.class);
        // 设置处理类 Handler
        enhancer.setCallback(new LogHandler());
        // 创建代理子类 ，使用父类接收
        UserDao dao = (UserDao)enhancer.create();   // 创建代理类
        dao.update();
        dao.select();
    }

    /**
     * 多个处理器
     */
    private static void multiHandler() {
        Enhancer enhancer = new Enhancer();
        // 设置超类，cglib是通过继承来实现的
        enhancer.setSuperclass(UserDao.class);
        // 设置处理类 Handler
        LogHandler logHandler = new LogHandler();
        Log2Handler log2Handler = new Log2Handler();
        enhancer.setCallbacks(new Callback[]{logHandler, log2Handler, NoOp.INSTANCE});
        // 使劲儿中回调选择过滤器
        enhancer.setCallbackFilter(new CglibHandlerFilter());
        // 创建代理子类 ，使用父类接收
        UserDao dao = (UserDao)enhancer.create();   // 创建代理类
        dao.update();
        dao.select();
    }


}
