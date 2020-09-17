package computer;

public class PortableMonitor extends Monitor {

    private String videoCamResolution;

    public PortableMonitor(String manufacturer, String model, String videoCamResolution) {
        super(manufacturer, model);
        this.videoCamResolution = videoCamResolution;
    }

    public String getVideoCamResolution() {
        return videoCamResolution;
    }

    public void setVideoCamResolution(String videoCamResolution) {
        this.videoCamResolution = videoCamResolution;
    }
}
