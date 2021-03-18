package design.publishsub;

import java.util.ArrayList;
import java.util.List;

public class MiSecretary extends Secretary{

    /**
     * 观察者列表
     */
    private List<Observer> observers = new ArrayList<>(0);

    /**
     * 通知者动作
     */
    private String action;

    /**
     *  添加观察者
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     *  移除不需要通知的观察者
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }


    /**
     *  通知所有观察者
     */
    public void notifyObserver(){
        // 对于不同场景可定向通知
        for(Observer observer : observers){
            observer.update();
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
