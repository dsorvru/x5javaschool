package log;

public class ConsoleLogger implements Logger {

    public void log(String message) {
        System.out.println("Log into console: " + message);
    }
}
