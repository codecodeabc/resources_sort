package logFrame.JDKlogs;


import java.util.logging.Logger;

/**
 * JDKLog是JDK官方提供的一个记录日志的方式，直接在JDK中就可以使用
 */
public class Demo {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger("Demo");

        logger.info("Hello World.");

    }
}
