package computer;

public class DesktopMonitor extends Monitor {

    private String buttons;

    public DesktopMonitor(String manufacturer, String model, String buttons) {
        super(manufacturer, model);
        this.buttons = buttons;
    }

    public String getButtons() {
        return buttons;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }
}
