package fruit;

public abstract class Fruit {

    public abstract float getWeight();

    @Override
    public String toString() {
        return super.toString() + " " + getWeight();
    }
}
