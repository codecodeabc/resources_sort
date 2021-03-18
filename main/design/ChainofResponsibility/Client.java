package design.ChainofResponsibility;

public class Client {
    public static void main(String[] args) {
        //设置责任链
        //AHandler --> BHandler
        BHandle bHandle = new BHandle();
        AHandle aHandle = new AHandle();
        aHandle.setHandler(bHandle);

        aHandle.handler(8);
    }
}
