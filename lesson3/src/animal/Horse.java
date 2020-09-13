package animal;

public class Horse extends Animal {

    private int maxSpeed;

    public Horse(String food, String location, int maxSpeed) {
        super(food, location);
        this.maxSpeed = maxSpeed;
    }

    public Horse() {
        this("овес", "стойло", 10);
    }

    @Override
    public void makeNoise() {
        System.out.println("Ржание");
    }
    
    @Override
    public void eat() {
        System.out.println("Чавкает");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
