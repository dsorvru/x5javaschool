package computer;

public class Ram {

    private String manufacturer;
    private long capacity;
    private long clockSpeed;
    private String type;

    public Ram(String manufacturer, long capacity, long clockSpeed, String type) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.clockSpeed = clockSpeed;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(long clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
