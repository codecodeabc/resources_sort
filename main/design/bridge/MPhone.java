package design.bridge;

public class MPhone extends Phone{

    @Override
    public void run() {
        phoneSoft.run();
    }
}
