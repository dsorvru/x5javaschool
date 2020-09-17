package computer;

public class App {

    public static void main(String[] args) {
        Computer portableComputer = Computer.create(new PortableComputerCreationStrategy());
        Computer desktopComputer = Computer.create(new DesktopComputerCreationStrategy());
    }
}
