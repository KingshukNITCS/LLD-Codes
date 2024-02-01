/* In a real Java backend development use case, imagine you have a base class representing data processing, and you want to add additional functionality such as logging or encryption without modifying the existing classes. The Decorator pattern can be used for this purpose. Here's a simplified example*/

// Component interface representing data processing
interface DataProcessor {
    void process(String data);
}

// Concrete component representing the base data processing
class BasicDataProcessor implements DataProcessor {
    @Override
    public void process(String data) {
        System.out.println("Processing basic data: " + data);
    }
}

// Decorator interface
interface DataProcessorDecorator extends DataProcessor {
}

// Concrete decorator adding logging functionality
class LoggingDecorator implements DataProcessorDecorator {
    private DataProcessor dataProcessor;

    public LoggingDecorator(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @Override
    public void process(String data) {
        System.out.println("Logging data before processing");
        dataProcessor.process(data);
        System.out.println("Logging data after processing");
    }
}

// Concrete decorator adding encryption functionality
class EncryptionDecorator implements DataProcessorDecorator {
    private DataProcessor dataProcessor;

    public EncryptionDecorator(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @Override
    public void process(String data) {
        System.out.println("Encrypting data before processing");
        dataProcessor.process(data);
        System.out.println("Encrypting data after processing");
    }
}

// Client code in a real backend development scenario
public class DecoratorBackendExample {
    public static void main(String[] args) {
        // Using decorators to add logging and encryption to data processing
        DataProcessor basicProcessor = new BasicDataProcessor();
        DataProcessorDecorator processorWithLogging = new LoggingDecorator(basicProcessor);
        DataProcessorDecorator processorWithLoggingAndEncryption = new EncryptionDecorator(processorWithLogging);

        // Now you can use processorWithLoggingAndEncryption for enhanced data processing
        processorWithLoggingAndEncryption.process("Sensitive Data");
    }
  }

/* In this example, DataProcessor is the component interface representing data processing, BasicDataProcessor is the concrete component, and LoggingDecorator and EncryptionDecorator are concrete decorators. The decorators add logging and encryption functionality to the base data processing without modifying the existing classes, making it easy to extend the functionality of the data processing component in a backend system.*/
