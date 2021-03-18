package design.publishsub;

/**
 * 具体观察者
 */
public class CollgueObserver extends Observer{

    public CollgueObserver(String name,Secretary secretary){
        super(name,secretary);
    }

    @Override
    public void update() {
        System.out.println("收到通知者发起通知");
    }
}
