package design.mediator;


/**
 * 同事抽象类
 */
abstract class Colleague {

    /**
     * 每个同事肯定要知道某个中介者
     */
    protected Mediator mediator;

}
