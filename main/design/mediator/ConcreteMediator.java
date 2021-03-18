package design.mediator;


/**
 * 具体中介者类
 */
public class ConcreteMediator extends Mediator{

    //中介者肯定要知道所有的同事
    //同事A
    private ColleagueA colleagueA;
    //同事B
    private ColleagueB colleagueB;


    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    /**
     * 该中介者所能处理的中介服务
     * @param msg
     * @param mediator
     */
    @Override
    public void sendMessage(String msg, Colleague colleague) {
        //同事A通知同事B
        if(colleague == colleagueA){
            colleagueB.notify(msg);
        }else if(colleague == colleagueB){
            colleagueA.notify(msg);
        }
    }
}
