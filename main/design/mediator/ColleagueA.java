package design.mediator;


/**
 * 具体同事类
 */
public class ColleagueA extends Colleague{


    public void send(String msg){
        mediator.sendMessage(msg,this);
    }

    public void notify(String message){
        System.out.println("同事A得到消息：" + message);
    }
}
