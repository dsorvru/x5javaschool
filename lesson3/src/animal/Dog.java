package animal;

public class Dog extends Animal {

    public Dog() {
        setLocation("будка");
        setFood("кость");
    }

    @Override
    public void makeNoise() {
        System.out.println("Гав!");
    }

    @Override
    public void eat() {
        System.out.println("Грызет");
    }
}
