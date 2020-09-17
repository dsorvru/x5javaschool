package computer;

public abstract class ComputerCreationStrategy {

    public Computer create() {
        return new Computer(
                createCpu(), createRam(), createVideoCard(), createStorageDevice(), createMonitor()
        );
    }

    public abstract Cpu createCpu();
    public abstract Ram createRam();
    public abstract StorageDevice createStorageDevice();
    public abstract VideoCard createVideoCard();
    public abstract Monitor createMonitor();
}
