/*The Observer design pattern is a behavioral pattern that allows an object, called the subject, to notify and update a list of dependent objects, called observers, automatically when its state changes. This pattern promotes loose coupling between the subject and observers, enabling a flexible and maintainable design.

Here's a simple example of the Observer design pattern implemented in Java:

```java*/
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Observer interface
interface Observer {
    void update();
}

// Concrete subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int newState) {
        state = newState;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Concrete observer
class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Updated state: " + subject.getState());
    }
}

// Main program
class ObserverExample {
    public static void main(String[] args) {
        // Create subject and observers
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        // Change the subject's state
        subject.setState(10);
        subject.setState(20);
    }
}
/*
```
java -cp /tmp/ku8DVvwKl2 ObserverExample

Updated state: 10

Updated state: 10

Updated state: 20

Updated state: 20



In this example, we have a `Subject` interface that provides methods for registering, removing, and notifying observers. The `Observer` interface defines the `update` method that is called when the subject's state changes.

The `ConcreteSubject` class implements the `Subject` interface and maintains a list of observers. It has methods to register, remove, and notify observers, as well as a `setState` method to change its state.

The `ConcreteObserver` class implements the `Observer` interface and keeps a reference to the subject it observes. It registers itself with the subject in its constructor and implements the `update` method to print the updated state.

In the `main` function, we create a `ConcreteSubject` object and two `ConcreteObserver` objects. We then change the subject's state twice, which triggers the observers' `update` method, resulting in the updated state being printed.

This example demonstrates the Observer pattern, where the subject (`ConcreteSubject`) notifies the observers (`ConcreteObserver`) automatically whenever its state changes
  */
