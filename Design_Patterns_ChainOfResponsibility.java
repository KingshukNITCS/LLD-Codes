
import java.io.*;

// Step 1: Define the Handler interface
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
