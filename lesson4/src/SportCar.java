public class SportCar extends Car {

    private int maxSpeed;

    public SportCar(String model, String category, int weight, Engine engine, int maxSpeed) {
        super(model, category, weight, engine);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void start() {
        System.out.println("SportCar поехал");
    }

    @Override
    public void stop() {
        System.out.println("SportCar остановился");
    }

    @Override
    public void printInfo() {
        System.out.println("Марка автомобиля: " + getModel());
        System.out.println("Класс автомобиля: " + getCategory());
        System.out.println("Вес автомобиля: " + getWeight());
        System.out.println("Предельная скорость: " + getMaxSpeed());
        getEngine().printInfo();
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
