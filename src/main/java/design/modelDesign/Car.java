package design.modelDesign;


/**
 * 模板设计模式
 */
public abstract class Car {

    protected abstract void alarm();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void engineBoom();

    final public void run(){
        start();
        engineBoom();
        alarm();
        stop();
    }
}
