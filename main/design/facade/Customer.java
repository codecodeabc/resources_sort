package design.facade;

public class Customer {

    public static void main(String[] args) {
        //联系一名基金经理
        Facade facade = new Facade();
        //跟经理说要买白酒混搭
        facade.baijiu();
    }
}
