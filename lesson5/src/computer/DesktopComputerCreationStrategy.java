package computer;

public class DesktopComputerCreationStrategy extends ComputerCreationStrategy {

    @Override
    public Cpu createCpu() {
        return new DesktopCpu(2000, 2, 512, "Desktop CPU", "CPU Inc.");
    }

    @Override
    public Ram createRam() {
        return new DesktopRam("Ram Inc.", 512, 1000, "SRAM");
    }

    @Override
    public StorageDevice createStorageDevice() {
        return new DesktopStorageDevice("Storage Inc.", 1024, StorageDeviceType.HDD, "3.5");
    }

    @Override
    public VideoCard createVideoCard() {
        return new DesktopVideoCard("Video Inc.", "Video memory", 256, CoolingSystem.ACTIVE);
    }

    @Override
    public Monitor createMonitor() {
        return new DesktopMonitor("Monitors Inc.", "Desktop model", "On/Off");
    }
}
