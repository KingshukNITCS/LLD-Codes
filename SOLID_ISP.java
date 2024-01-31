/*The Interface Segregation Principle (ISP) is a principle in object-oriented programming that states that clients should not be forced to depend on interfaces they do not use. It encourages the creation of smaller, more focused interfaces instead of large, general-purpose interfaces.

Here's a simple example in Java that demonstrates the Interface Segregation Principle:

```java*/
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface FaxMachine {
    void fax();
}

class AllInOnePrinter implements Printer, Scanner, FaxMachine {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax() {
        System.out.println("Sending fax...");
    }
}

class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
}

public class InterfaceSegregationPrincipleExample {
    public static void main(String[] args) {
        AllInOnePrinter allInOnePrinter = new AllInOnePrinter();
        allInOnePrinter.print();
        allInOnePrinter.scan();
        allInOnePrinter.fax();

        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();
    }
}
/*```

In this example, we have three interfaces: `Printer`, `Scanner`, and `FaxMachine`. Each interface represents a specific functionality related to printing, scanning, and faxing.

The `AllInOnePrinter` class implements all three interfaces, providing implementations for the `print`, `scan`, and `fax` methods. This class represents a printer that can perform all the functionalities.

The `SimplePrinter` class, on the other hand, only implements the `Printer` interface, as it is a simpler printer that does not have scanning or faxing capabilities.

In the `main` function, we create an instance of `AllInOnePrinter` and call its `print`, `scan`, and `fax` methods. We also create an instance of `SimplePrinter` and call its `print` method.

By adhering to the Interface Segregation Principle, we avoid forcing the client code to depend on interfaces it does not need. In this example, the `SimplePrinter` class only implements the `Printer` interface, which is the functionality it requires. The `AllInOnePrinter` class implements all three interfaces, but the client code can choose to use only the methods it needs, such as `print`, `scan`, or `fax`.

This approach allows for more modular and maintainable code. If new functionality is added in the future, new interfaces can be created, and classes can choose to implement only the interfaces that are relevant to them, without affecting existing client code.
  */
