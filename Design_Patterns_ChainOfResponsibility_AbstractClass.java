// Step 1: Define the Handler abstract class 
abstract class EmailProcessor {
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

    protected abstract boolean canHandleEmail(Email email);

    protected abstract void handleEmail(Email email);
}

// Step 2: Implement the ConcreteHandlers
class SpamEmailProcessor extends EmailProcessor {
    protected boolean canHandleEmail(Email email) {
        // Check if the email is spam
        return email.isSpam();
    }

    protected void handleEmail(Email email) {
        System.out.println("This email is marked as spam: " + email.getContent());
    }
}

class SalesEmailProcessor extends EmailProcessor {
    protected boolean canHandleEmail(Email email) {
        // Check if the email is a sales-related email
        return email.getCategory().equals("sales");
    }

    protected void handleEmail(Email email) {
        System.out.println("This is a sales-related email: " + email.getContent());
    }
}

class GeneralInquiryEmailProcessor extends EmailProcessor {
    protected boolean canHandleEmail(Email email) {
        // Check if the email is a general inquiry
        return email.getCategory().equals("general");
    }

    protected void handleEmail(Email email) {
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

The Chain of Responsibility is a behavioral design pattern that allows an object to pass a request along a chain of potential handlers until one of them handles the request. Each handler in the chain has the ability to either handle the request or pass it on to the next handler in line.

Here's a detailed explanation of the Chain of Responsibility design pattern in Java, along with a code implementation:

1. First, let's define the components of the pattern:
   - Handler: An abstract class or interface that defines a common interface for all concrete handlers. It typically contains a reference to the next handler in the chain.
   - ConcreteHandler: Concrete implementations of the Handler interface. Each concrete handler decides whether to handle the request or pass it to the next handler.

2. Implementing the Chain of Responsibility pattern:

Here's an example implementation where we have a series of email processors, each responsible for performing a specific task on an email.

In this code, we have three email processors: SpamEmailProcessor, SalesEmailProcessor, and GeneralInquiryEmailProcessor. Each processor has its own logic to determine whether it can handle an email or not. If a processor can handle an email, it performs the required action; otherwise, it passes the email to the next processor in the chain. The chain is established by setting the nextProcessor field of each processor.

In the Main class, we create instances of the processors, connect them in the desired order, and then pass emails through the chain using the processEmail() method. Depending on the content and category of the email, it will be handled by the appropriate processor in the chain.

This way, the Chain of Responsibility pattern allows for flexible and dynamic handling of requests, as new processors can be added or removed from the chain without affecting the existing ones.

    */
