package task2;

public class Engine {

    private int power;
    private String manufacturer;

    public Engine(String manufacturer, int power) {
        this.manufacturer = manufacturer;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void printInfo() {
        System.out.println("Производитель двигателя:" + manufacturer);
        System.out.println("Мощность двигателя:" + power);
    }
}
