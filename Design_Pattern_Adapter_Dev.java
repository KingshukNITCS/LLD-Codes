/* In a real Java backend development use case, imagine you have an existing class for logging messages, and you want to integrate it with a logging framework that uses a different interface. You can use the Adapter pattern to make them work together. Here's a simplified example:*/

// Target interface for the new logging framework
interface Logger {
    void logMessage(String message);
}

// Adaptee (existing class with a different interface)
class LegacyLogger {
    void log(String message) {
        System.out.println("Legacy logging: " + message);
    }
}

// Adapter class
class LegacyLoggerAdapter implements Logger {
    private LegacyLogger legacyLogger;

    public LegacyLoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void logMessage(String message) {
        legacyLogger.log(message);
    }
}

// Client code in a real backend development scenario
public class AdapterBackendExample {
    public static void main(String[] args) {
        // Using the new Logger interface with the legacy logging class
        Logger loggerAdapter = new LegacyLoggerAdapter(new LegacyLogger());
        loggerAdapter.logMessage("Log this message using the new Logger interface");
    }
}

/* In this example, Logger is the target interface for the new logging framework, LegacyLogger is the existing class with a different interface, and LegacyLoggerAdapter is the adapter class. The adapter class allows the new logging framework to work with the existing legacy logging class seamlessly, making it easier to integrate different components in a backend system.

*/
