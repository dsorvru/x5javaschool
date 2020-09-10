package animal;

public class Cat extends Animal {

    public Cat() {
        setLocation("дом");
        setFood("молоко");
    }

    @Override
    public void makeNoise() {
        System.out.println("Мяу!");
    }

    @Override
    public void eat() {
        System.out.println("Лижет");
    }
}
