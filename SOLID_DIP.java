/*The Dependency Inversion Principle (DIP) is a principle in object-oriented programming that states that high-level modules should not depend on low-level modules. Both should depend on abstractions. It promotes loose coupling between classes and modules by inverting the traditional dependency relationships.

Here's a simple example in Java that demonstrates the Dependency Inversion Principle:

```java*/
interface MessageSender {
    void sendMessage(String message);
}

class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationService {
    private MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message) {
        messageSender.sendMessage(message);
    }
}

public class DependencyInversionPrincipleExample {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        NotificationService emailNotificationService = new NotificationService(emailSender);
        emailNotificationService.sendNotification("Hello, this is an email notification!");

        MessageSender smsSender = new SMSNotification();
        NotificationService smsNotificationService = new NotificationService(smsSender);
        smsNotificationService.sendNotification("Hello, this is an SMS notification!");
    }
}
/*```

In this example, we have the `MessageSender` interface, which defines a `sendMessage` method. The `EmailSender` and `SMSNotification` classes implement this interface and provide their own implementations of the `sendMessage` method.

The `NotificationService` class depends on the `MessageSender` interface instead of concrete implementations. It has a constructor that takes a `MessageSender` object as a parameter. This allows the `NotificationService` class to work with any class that implements the `MessageSender` interface, enabling loose coupling.

In the `main` function, we create an instance of `EmailSender` and pass it to the `NotificationService` constructor, creating an `emailNotificationService` object. We then call the `sendNotification` method, which internally uses the `EmailSender` object to send the email notification.

Similarly, we create an instance of `SMSNotification` and pass it to the `NotificationService` constructor, creating an `smsNotificationService` object. We call the `sendNotification` method, which uses the `SMSNotification` object to send the SMS notification.

By adhering to the Dependency Inversion Principle, we decouple the high-level `NotificationService` class from the low-level `MessageSender` implementations (`EmailSender` and `SMSNotification`). The `NotificationService` depends on the abstraction provided by the `MessageSender` interface, making it more flexible and allowing different types of message senders to be easily plugged in without modifying the `NotificationService` class.

This principle promotes modularity, testability, and maintainability by reducing direct dependencies between classes and allowing for easier substitution of implementations.
  */
