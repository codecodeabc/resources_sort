package design.decorator;


/**
 * 具体装饰对象
 */
public class ConcreteComponent extends Component {

    @Override
    public void operator() {
        System.out.println("具体装饰对象");
    }


    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteComponentA concreteComponentA = new ConcreteComponentA();
        ConcreteComponentB concreteComponentB = new ConcreteComponentB();
        concreteComponentA.setComponent(component);
        concreteComponentB.setComponent(concreteComponentA);

        concreteComponentB.operator();
    }
}
