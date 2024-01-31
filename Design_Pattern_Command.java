/* Command design pattern encapsulates a request as an object, allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. Here's a simple Java program illustrating the Command pattern:*/
// Command interface
interface Command {
    void execute();
}

// Concrete Command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }

    void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOnCommand);

        // Pressing the button invokes the command
        remote.pressButton();
    }
}

/*this example, Command is the command interface, LightOnCommand is a concrete command, and Light is the receiver. The RemoteControl is the invoker that triggers the command. This pattern allows you to decouple the sender (invoker) from the receiver and provides a way to parameterize objects with operations, queue requests, and support undoable operations.


*/
