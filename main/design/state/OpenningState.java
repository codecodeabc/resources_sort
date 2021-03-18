package design.state;

public class OpenningState extends LiftState{
    @Override
    public void open() {
        System.out.println("open");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        context.getLiftState().close();
    }

    @Override
    public void run() {
       //do nothing
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        context.getLiftState().stop();
    }
}
