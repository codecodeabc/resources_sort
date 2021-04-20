package design.facade;

import design.facade.system.SystemA;
import design.facade.system.SystemB;
import design.facade.system.SystemC;

/**
 * 基金经理
 */
public class Facade {

    private SystemA systemA;

    private SystemB systemB;

    private SystemC systemC;

    /**
     * 诺安
     */
    public void nuoan(){
        systemA.methodA();
        systemB.methodB();
    }

    /**
     * 白酒
     */
    public void baijiu(){
        systemA.methodA();
        systemC.methodC();
    }
}
