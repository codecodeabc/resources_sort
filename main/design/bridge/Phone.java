package design.bridge;

/**
 * 手机品牌抽象
 */
abstract class Phone {

    protected Soft phoneSoft;

    public void setPhoneSoft(Soft phoneSoft) {
        this.phoneSoft = phoneSoft;
    }

    public abstract void run();
}
