package animal;

public class Horse extends Animal {

    public Horse() {
        setLocation("стойло");
        setFood("овес");
    }

    @Override
    public void makeNoise() {
        System.out.println("Ржание");
    }
    @Override
    public void eat() {
        System.out.println("Чавкает");
    }
}
