package design.state;

/**
 * 电梯状态抽象类
 */
abstract class LiftState {

    //每个状态保存一个上下文对象
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();



}
