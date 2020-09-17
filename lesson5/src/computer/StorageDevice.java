package computer;

public abstract class StorageDevice {

    private String manufacturer;
    private long capacity;
    private StorageDeviceType type;
    private String formFactor;

    public StorageDevice(String manufacturer, long capacity, StorageDeviceType type, String formFactor) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.type = type;
        this.formFactor = formFactor;
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

    public StorageDeviceType getType() {
        return type;
    }

    public void setType(StorageDeviceType type) {
        this.type = type;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
