package log;

public class DbLogger implements Logger {

    public void log(String message) {
        System.out.println("Log into database: " + message);
    }
}
