package design.decorator;


/**
 * 装饰抽象类
 */
abstract class Decorator extends Component{

    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operator() {
        if(component != null){
            component.operator();
        }
    }
}
