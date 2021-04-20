package design.publishsub;

/**
 * 抽象观察者
 */
abstract class Observer {

    /**
     * 定义观察者属性
     */
    private String name;

    /**
     * 观察者需要知道对应通知者
     */
    private Secretary sub;

    public Observer(String name, Secretary secretary) {
        this.name = name;
        this.sub = secretary;
    }

    public abstract void update();
}
