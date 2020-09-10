public abstract class Car {

    private String model;
    private String category;
    private int weight;
    private Engine engine;

    public Car(String model, String category, int weight, Engine engine) {
        this.model = model;
        this.category = category;
        this.weight = weight;
        this.engine = engine;
    }

    public abstract void start();
    public abstract void stop();
    public abstract void printInfo();

    public String getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public int getWeight() {
        return weight;
    }

    public Engine getEngine() {
        return engine;
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }
    public void turnLeft() {
        System.out.println("Поворот налево");
    }

}
