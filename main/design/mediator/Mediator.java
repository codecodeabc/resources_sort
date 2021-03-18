package design.mediator;


/**
 * 中介者抽象类
 */
abstract class Mediator {

    /**
     * 指定
     * @param msg
     * @param mediator
     */
    public abstract void sendMessage(String msg,Colleague mediator);
}
