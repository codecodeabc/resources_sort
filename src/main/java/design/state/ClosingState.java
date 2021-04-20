package design.state;

public class ClosingState extends LiftState{

    /**
     * 关闭状态下可打开门
     */
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    /**
     * 关闭状态下可运行电梯
     */
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    /**
     * 关闭状态下可停止电梯
     */
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
