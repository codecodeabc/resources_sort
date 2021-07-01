package netty;


import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * 信号量监听处理器
 */
public class KillHandler implements SignalHandler {


    public void registerSignal() {
        String signalName = System.getProperties().getProperty("os.name").toLowerCase().startsWith("win") ? "INT" : "TERM";
        Signal signal = new Signal(signalName);
        Signal.handle(signal, this);
    }

    @Override
    public void handle(Signal signal) {

        if (signal.getName().equals("TERM")) {
            System.out.println("监听到TERM信号量");
        } else if (signal.getName().equals("INT") || signal.getName().equals("HUP")) {
            System.out.println("监听到INT信号量");
        } else {
        }
    }
}
