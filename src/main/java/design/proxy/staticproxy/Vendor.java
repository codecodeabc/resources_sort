package design.proxy.staticproxy;

/**
 * 委托类 - 被代理的类
 */
public class Vendor implements Sell {
    public void sell() {
        System.out.println("In sell method");
    }

    public void ad() {
        System.out.println("ad method");
    }
}

