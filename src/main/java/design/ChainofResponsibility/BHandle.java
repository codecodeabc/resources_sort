package design.ChainofResponsibility;

public class BHandle extends Handle{
    @Override
    public void handler(int request) {
        //当前处理者处理
        if(request <= 10){
            System.out.println("BHandler do it");
        }else{
            //交于下一位处理者处理
            handle.handler(request);
        }
    }
}
