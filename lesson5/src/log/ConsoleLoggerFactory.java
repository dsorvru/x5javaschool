package log;

public class ConsoleLoggerFactory implements LoggerFactory {

    public Logger createLogger() {
        return new ConsoleLogger();
    }
}
