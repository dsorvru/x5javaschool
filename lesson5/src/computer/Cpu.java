package computer;

public class Cpu {

    private long clockSpeed;
    private int numberOfCores;
    private long cacheCapacity;
    private String name;
    private String manufacturer;

    public Cpu(long clockSpeed, int numberOfCores, long cacheCapacity, String name, String manufacturer) {
        this.clockSpeed = clockSpeed;
        this.numberOfCores = numberOfCores;
        this.cacheCapacity = cacheCapacity;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public long getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(long clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public long getCacheCapacity() {
        return cacheCapacity;
    }

    public void setCacheCapacity(long cacheCapacity) {
        this.cacheCapacity = cacheCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
