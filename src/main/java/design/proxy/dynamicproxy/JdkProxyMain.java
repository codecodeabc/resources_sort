package design.proxy.dynamicproxy;

import design.proxy.staticproxy.Sell;
import design.proxy.staticproxy.Vendor;

import java.io.Serializable;
import java.lang.reflect.Proxy;

public class JdkProxyMain implements Serializable {


    public static void main(String[] args) {
        //创建中介类实例 - 也就是代理处理类
        DynamicHandler inter = new DynamicHandler(new Vendor());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件,动态代理的文件会被保存
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取代理类实例sell
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();
    }
}
