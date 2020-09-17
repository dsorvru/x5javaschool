package computer;

public class Computer {

    private Cpu cpu;
    private Ram ram;
    private VideoCard videoCard;
    private StorageDevice storageDevice;
    private Monitor monitor;

    public Computer(Cpu cpu, Ram ram, VideoCard videoCard, StorageDevice storageDevice, Monitor monitor) {
        this.cpu = cpu;
        this.ram = ram;
        this.videoCard = videoCard;
        this.storageDevice = storageDevice;
        this.monitor = monitor;
    }

    public static Computer create(ComputerCreationStrategy strategy) {
        return strategy.create();
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public StorageDevice getStorageDevice() {
        return storageDevice;
    }

    public void setStorageDevice(StorageDevice storageDevice) {
        this.storageDevice = storageDevice;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
