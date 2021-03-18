package design.mediator;


/**
 * 具体同事B
 */
public class ColleagueB extends Colleague{

    public void send(String msg){
        mediator.sendMessage(msg,this);
    }


    public void notify(String message){
        System.out.println("同事B得到消息：" + message);
    }
}
