package design.decorator;


/**
 * 装饰操作
 */
public class ConcreteComponentA extends Decorator{

    @Override
    public void operator() {
        component.operator();
        //本类独有方法，装饰Conpoment
        decoratorComponent();
        System.out.println("装饰OK");
    }

    private void decoratorComponent() {
        System.out.println("进行装饰操作AAA。。。");
    }
}
