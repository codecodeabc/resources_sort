package design.proxy.cglibproxy;


/**
 * 委托类 - 被代理的类
 */
public class UserDao {
    public void select() {
        System.out.println("UserDao 查询 selectById");
    }
    public void update() {
        System.out.println("UserDao 更新 update");
    }
}
