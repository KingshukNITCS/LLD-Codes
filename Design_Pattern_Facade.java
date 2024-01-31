/*Facade design pattern provides a simplified interface to a set of interfaces in a subsystem. Here's a simple Java program illustrating the Facade pattern:*/

// Complex subsystem classes
class CPU {
    void processData() {
        System.out.println("Processing data");
    }
}

class Memory {
    void load() {
        System.out.println("Loading data into memory");
    }
}

class HardDrive {
    void readData() {
        System.out.println("Reading data from hard drive");
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.processData();
        memory.load();
        hardDrive.readData();
        System.out.println("Computer started successfully");
    }
}

// Client code
public class FacadeExample {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.startComputer();
    }
}

/*this example, CPU, Memory, and HardDrive represent complex subsystem classes. The ComputerFacade acts as a simplified interface to these subsystems. The client code only needs to interact with the ComputerFacade to start the computer, and the facade internally handles the interactions with the subsystems, providing a more straightforward interface for the client.
*/
