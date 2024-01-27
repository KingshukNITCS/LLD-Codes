// Step 1: Define the Handler interface
interface EmailProcessor {
    void setNextProcessor(EmailProcessor nextProcessor);
    void processEmail(Email email);
}

// Step 2: Implement the ConcreteHandlers
class SpamEmailProcessor implements EmailProcessor {
    private EmailProcessor nextProcessor;

    public void setNextProcessor(EmailProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processEmail(Email email) {
        if (canHandleEmail(email)) {
            handleEmail(email);
        } else if (nextProcessor != null) {
            nextProcessor.processEmail(email);
        }
    }

    private boolean canHandleEmail(Email email) {
        // Check if the email is spam
        return email.isSpam();
    }

    private void handleEmail(Email email) {
        System.out.println("This email is marked as spam: " + email.getContent());
    }
}

class SalesEmailProcessor implements EmailProcessor {
    private EmailProcessor nextProcessor;

    public void setNextProcessor(EmailProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processEmail(Email email) {
        if (canHandleEmail(email)) {
            handleEmail(email);
        } else if (nextProcessor != null) {
            nextProcessor.processEmail(email);
        }
    }

    private boolean canHandleEmail(Email email) {
        // Check if the email is a sales-related email
        return email.getCategory().equals("sales");
    }

    private void handleEmail(Email email) {
        System.out.println("This is a sales-related email: " + email.getContent());
    }
}

class GeneralInquiryEmailProcessor implements EmailProcessor {
    private EmailProcessor nextProcessor;

    public void setNextProcessor(EmailProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processEmail(Email email) {
        if (canHandleEmail(email)) {
            handleEmail(email);
        } else if (nextProcessor != null) {
            nextProcessor.processEmail(email);
        }
    }

    private boolean canHandleEmail(Email email) {
        // Check if the email is a general inquiry
        return email.getCategory().equals("general");
    }

    private void handleEmail(Email email) {
        System.out.println("This is a general inquiry: " + email.getContent());
    }
}

// Step 3: Create and connect the chain
class Main {
    public static void main(String[] args) {
        // Create the processors
        EmailProcessor spamProcessor = new SpamEmailProcessor();
        EmailProcessor salesProcessor = new SalesEmailProcessor();
        EmailProcessor generalInquiryProcessor = new GeneralInquiryEmailProcessor();

        // Connect the chain
        spamProcessor.setNextProcessor(salesProcessor);
        salesProcessor.setNextProcessor(generalInquiryProcessor);

        // Process the emails
        Email email1 = new Email("Buy our product!", "sales");
        spamProcessor.processEmail(email1);

        Email email2 = new Email("I have a question.", "general");
        spamProcessor.processEmail(email2);
    }
}

// Step 4: Define the Email class
class Email {
    private String content;
    private String category;

    public Email(String content, String category) {
        this.content = content;
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public boolean isSpam() {
        // Logic to check if the email is spam
        return content.contains("spam");
    }
  }

/*

Output 

This is a sales-related email: Buy our product!
This is a general inquiry: I have a question.

*/

/*

Here's the modified code where the `EmailProcessor` is an interface instead of an abstract class.

In this modified version, the `EmailProcessor` interface defines the common methods `setNextProcessor()` and `processEmail()`. Each concrete handler (`SpamEmailProcessor`, `SalesEmailProcessor`, `GeneralInquiryEmailProcessor`) implements these methods and maintains a reference to the next processor in the chain.

The `processEmail()` method in each concrete handler follows the same logic as before, checking if it can handle the email or passing it to the next processor in the chain.

The `Main` class and the `Email` class remain the same as in the previous example.

This implementation still achieves the Chain of Responsibility pattern, but with the handler as an interface instead of an abstract class.

___________________


In Java, both abstract classes and interfaces are used to define contracts for classes. However, there are some differences between them, and the choice between using an abstract class or an interface depends on the specific requirements and design considerations of your application. Here are the key differences:

1. Inheritance: An abstract class can provide a partial implementation of a class, including instance variables, constructors, and concrete methods. Subclasses can extend the abstract class and inherit the implemented behavior. On the other hand, an interface only declares method signatures, constants, and nested types, without providing any implementation. Classes can implement multiple interfaces but can extend only one abstract class.

2. Default Method Implementation: In Java 8 and later versions, interfaces can have default methods, which provide a default implementation for a method. This allows interfaces to evolve without breaking compatibility with existing implementing classes. Abstract classes, on the other hand, do not have this feature. Any method declared in an abstract class needs to be implemented by its subclasses.

3. Constructor: An abstract class can have constructors, which are used to initialize the state of the class. Interfaces, however, cannot have constructors.

4. Access Modifiers: In an abstract class, you can specify different access modifiers for methods and variables, allowing you to control the visibility of these members. In an interface, all methods are implicitly public, and all variables are implicitly public, static, and final.

5. Multiple Inheritance: A class can implement multiple interfaces, allowing for multiple inheritance of type. On the other hand, a class can extend only one abstract class, restricting multiple inheritance of implementation.

When to use an abstract class:
- When you want to provide a common base implementation that subclasses can inherit.
- When you want to define non-static or non-final fields in the base class.
- When you want to provide constructors to initialize the state of the class.

When to use an interface:
- When you want to define a contract that multiple unrelated classes can implement.
- When you want to achieve multiple inheritance of type.
- When you want to provide a default implementation for some methods without affecting existing implementations.

In the context of the Chain of Responsibility design pattern, choosing an abstract class or interface for the handler depends on your specific requirements. If you anticipate that the handlers will share some common implementation or state, an abstract class may be more appropriate. However, if the handlers are independent and don't share implementation details, using an interface may be a better choice to allow for more flexibility and multiple inheritance of type.

*/
