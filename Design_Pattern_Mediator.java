/* The Mediator design pattern is used to define an object that encapsulates how a set of objects interact. Instead of objects interacting directly with each other, they communicate through a mediator, promoting loose coupling. Here's a simple example in Java:

Let's consider a chat application where users can send messages to each other through a mediator.

```java*/
import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);
}

// Concrete Mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Send the message to all users except the sender
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague interface
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.addUser(this);
    }

    abstract void sendMessage(String message);

    abstract void receiveMessage(String message);
}

// Concrete Colleague
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void sendMessage(String message) {
        System.out.println(name + " sending message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Client code
public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new ChatUser(mediator, "User1");
        User user2 = new ChatUser(mediator, "User2");
        User user3 = new ChatUser(mediator, "User3");

        user1.sendMessage("Hello, everyone!");

        /*
         * Output:
         * User1 sending message: Hello, everyone!
         * User2 received message: Hello, everyone!
         * User3 received message: Hello, everyone!
         */
    }
}
/*```

In this example:

- `ChatMediator` is the Mediator interface that defines the communication contract.
- `ChatMediatorImpl` is the concrete implementation of the mediator that manages the users.
- `User` is the Colleague interface representing users in the chat application.
- `ChatUser` is the concrete implementation of a user.
- The client code demonstrates how users can send and receive messages through the mediator. The mediator ensures that users don't need to know about each other directly, promoting decoupling.*/
