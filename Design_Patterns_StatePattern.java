/* The State design pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. It encapsulates different behaviors as separate classes, which can be dynamically switched at runtime.

Here's an example of the State design pattern in Java:

```java*/
// Context class that maintains the current state
class Context {
    private State state;

    public Context() {
        // Set an initial state
        state = new StateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void performAction() {
        state.handleAction(this);
    }
}

// State interface that defines the common behavior for different states
interface State {
    void handleAction(Context context);
}

// Concrete state classes that implement the State interface
class StateA implements State {
    public void handleAction(Context context) {
        System.out.println("Performing action in State A");
        // Transition to a different state if needed
        context.setState(new StateB());
    }
}

class StateB implements State {
    public void handleAction(Context context) {
        System.out.println("Performing action in State B");
        // Transition to a different state if needed
        context.setState(new StateA());
    }
}

// Example usage:
class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.performAction(); // Output: "Performing action in State A"
        context.performAction(); // Output: "Performing action in State B"
        context.performAction(); // Output: "Performing action in State A"
    }
}
/*```

In this example, we have a `Context` class that represents the context in which the state changes. It maintains a reference to the current state and provides methods to set the state and perform an action.

The `State` interface defines the common behavior for different states. Each concrete state class (`StateA` and `StateB`) implements the `State` interface and provides its own implementation of the `handleAction()` method.

In the `performAction()` method of the `Context` class, the current state's `handleAction()` method is invoked, which performs the appropriate action based on the state. The state can be dynamically changed by transitioning to a different state using the `setState()` method.

When you run the example, you will see the output:

```
Performing action in State A
Performing action in State B
Performing action in State A
```

As you can see, the behavior of the `Context` object changes based on its internal state. The State design pattern allows for easy addition of new states and facilitates the adherence to the Open-Closed Principle by separating the behavior of different states into separate classes.
*/
