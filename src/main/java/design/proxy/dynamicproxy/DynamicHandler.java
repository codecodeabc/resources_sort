package design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Vendor类作为委托类，BusinessAgent类作为代理类
 *
 * 使用动态代理时，我们需要定义一个位于代理类与委托类之间的中介类
 * 中介类必须实现InvocationHandler接口
 *
 * 我们调用代理类对象的方法时，这个“调用”会转送到invoke方法中，代理类对象作为proxy参数传入，
 * 参数method标识了我们具体调用的是代理类的哪个方法，args为这个方法的参数。这样一来，我们对代理类中的所有方法的调用都会变为对invoke的调用，
 * 这样我们可以在invoke方法中添加统一的处理逻辑(也可以根据method参数对不同的代理类方法做不同的处理)。
 * 因此我们只需在中介类的invoke方法实现中输出“before”，然后调用委托类的invoke方法，再输出“after”。下面我们来一步一步具体实现它。
 *
 * 动态代理关系由两组静态代理关系组成，这就是动态代理的原理。
 */
public class DynamicHandler implements InvocationHandler {
    //obj为委托类对象;
    private Object obj;

    public DynamicHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }
    /**
     * 从以上代码中我们可以看到，中介类持有一个委托类对象引用，在invoke方法中调用了委托类对象的相应方法，看到这里是不是觉得似曾相识?
     * 通过聚合方式持有委托类对象引用，把外部对invoke的调用最终都转为对委托类对象的调用。这不就是我们上面介绍的静态代理的一种实现方式吗?
     * 实际上，中介类与委托类构成了静态代理关系，在这个关系中，中介类是代理类，委托类就是委托类;
     * 代理类与中介类也构成一个静态代理关系，在这个关系中，中介类是委托类，代理类是代理类。
     * 也就是说，动态代理关系由两组静态代理关系组成，这就是动态代理的原理。下面我们来介绍一下如何”指示“以动态生成代理类。
     */
}
