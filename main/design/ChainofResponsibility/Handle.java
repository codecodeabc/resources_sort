package design.ChainofResponsibility;


/**
 * 责任链模式
 */
public abstract class Handle {

    //责任链下一位处理者
    protected Handle handle;

    //设置责任链下一位处理者
    public void setHandler(Handle handler){
        this.handle = handler;
    };

    //每个处理者处理方法
    abstract public void handler(int request);
}
