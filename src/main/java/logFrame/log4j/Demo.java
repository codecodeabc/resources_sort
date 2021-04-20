package logFrame.log4j;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        log.info("test-{}","info");
        log.debug("test-{}","debug");
        log.warn("test-{}","warn");
        log.error("test-{}","error");
    }
}
