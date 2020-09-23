package task2;

public class Lorry extends Car {

    private int loadCapacity;

    public Lorry(String model, String category, int weight, Engine engine, int loadCapacity) {
        super(model, category, weight, engine);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void start() {
        System.out.println("Грузовик поехал");
    }

    @Override
    public void stop() {
        System.out.println("Грузовик остановился");
    }

    @Override
    public void printInfo() {
        System.out.println("Марка автомобиля: " + getModel());
        System.out.println("Класс автомобиля: " + getCategory());
        System.out.println("Вес автомобиля: " + getWeight());
        System.out.println("Грузоподъемность: " + getLoadCapacity());
        getEngine().printInfo();
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
