/* Here's an explanation of the Null Object Design Pattern with a Java program:
Purpose:
To avoid explicit null checks and provide a default behavior for absent objects.
To simplify client code and make it more readable.
To prevent NullPointerExceptions.
Key Components:
Abstract Class: Defines the interface for objects, both real and null.
Concrete Class(es): Implement the interface for real objects.
Null Object Class: Implements the interface with do-nothing or default behaviors.
Client Code: Uses objects without the need for null checks.

Key Points:
The client code doesn't need to check for nulls before calling methods on the logger.
The NullLogger class provides a default, no-op implementation.
The Null Object Pattern makes code cleaner and more robust.
It's often used in collections (e.g., Collections.emptyList()), optional fields, and strategies.


    
    
 */


// Abstract class representing a logger
interface Logger {
    void log(String message);
}

// Concrete class for real logger
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging: " + message);
    }
}

// Null object class for absent logger
class NullLogger implements Logger {
    @Override
    public void log(String message) {
        // Do nothing
    }
}

// Client code using the logger
class Client {
    private Logger logger;

    Client(Logger logger) {
        this.logger = logger; // Could be a real logger or a null logger
    }

    void process() {
        // No null check needed
        logger.log("Processing started");
        // ...
        logger.log("Processing finished");
    }
}

// ... your existing code ...

class Main {

  public static void main(String[] args) {
    // Create an instance of the Client class and call its process() method
    Client client = new Client(new ConsoleLogger()); // Or use NullLogger() for silence
    client.process();
    // Usage
    Client client1 = new Client(new ConsoleLogger()); // Real logger
    Client client2 = new Client(new NullLogger());   // Null logger

    client1.process(); // Outputs "Logging: Processing started" and "Logging: Processing finished"
    client2.process(); // Now calls the process() method correctly

  }
}


