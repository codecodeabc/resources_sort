package design.proxy.staticproxy;

/**
 * 静态代理类
 *
 * 静态代理的局限在于运行前必须编写好代理类
 */
public class BusinessAgent implements Sell {

    /**
     * 被代理的对象类
     */
    private Sell vendor;

    public BusinessAgent(Sell vendor){
        this.vendor = vendor;
    }

    public void sell() {
        vendor.sell();
    }

    public void ad() {
        vendor.ad();
    }
}
