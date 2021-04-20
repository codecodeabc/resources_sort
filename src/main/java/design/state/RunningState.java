package design.state;

public class RunningState extends LiftState{
    @Override
    public void open() {
        //do nothing
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        System.out.println("running");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        context.getLiftState().stop();
    }
}
