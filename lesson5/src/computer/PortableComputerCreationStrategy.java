package computer;

public class PortableComputerCreationStrategy extends ComputerCreationStrategy {
    @Override
    public Cpu createCpu() {
        return new PortableCpu(1000, 1, 256, "Portable CPU", "CPU Inc.");
    }

    @Override
    public Ram createRam() {
        return new PortableRam("Ram Inc.", 256, 1000, "DRAM");
    }

    @Override
    public StorageDevice createStorageDevice() {
        return new PortableStorageDevice("Storage Inc.", 256, StorageDeviceType.SDD, "2.5");
    }

    @Override
    public VideoCard createVideoCard() {
        return new PortableVideoCard("Video Inc.", "Video memory", 128, computer.CoolingSystem.PASSIVE);
    }

    @Override
    public Monitor createMonitor() {
        return new PortableMonitor("Monitors Inc.", "Portable model", "720p");
    }
}
