package design.modelDesign;


/**
 * 继承 Car 抽象类，实现 car 汽车类细节，填充run()模板
 */
public class BenciCar extends Car{
    @Override
    protected void alarm() {
        System.out.println("benci open alarm");
    }

    @Override
    protected void start() {
        System.out.println("benci car start");
    }

    @Override
    protected void stop() {
        System.out.println("benci car stop");
    }

    @Override
    protected void engineBoom() {
        System.out.println("benci car engineBoom");
    }

    public static void main(String[] args) {
        BenciCar benciCar = new BenciCar();
        benciCar.run();
    }

}
