package animal;

public class Cat extends Animal {

    private int numberOfLives;

    public Cat(String food, String location, int numberOfLives) {
        super(food, location);
        this.numberOfLives = numberOfLives;
    }

    public Cat() {
        this("молоко", "дом", 9);
    }

    @Override
    public void makeNoise() {
        System.out.println("Мяу!");
    }

    @Override
    public void eat() {
        System.out.println("Лижет");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }
}
