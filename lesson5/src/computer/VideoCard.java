package computer;

public class VideoCard {

    private String manufacturer;
    private String memoryType;
    private long memoryCapacity;
    private CoolingSystem collingSystem;

    public VideoCard(String manufacturer, String memoryType, long memoryCapacity, CoolingSystem collingSystem) {
        this.manufacturer = manufacturer;
        this.memoryType = memoryType;
        this.memoryCapacity = memoryCapacity;
        this.collingSystem = collingSystem;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public long getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(long memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public CoolingSystem getCollingSystem() {
        return collingSystem;
    }

    public void setCollingSystem(CoolingSystem collingSystem) {
        this.collingSystem = collingSystem;
    }
}
