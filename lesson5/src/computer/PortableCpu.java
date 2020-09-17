package computer;

public class PortableCpu extends Cpu {

    public PortableCpu(long clockSpeed, int numberOfCores, long cacheCapacity, String name, String manufacturer) {
        super(clockSpeed, numberOfCores, cacheCapacity, name, manufacturer);
    }
}
