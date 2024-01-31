/* The Bridge design pattern separates abstraction from implementation, allowing them to vary independently. Here's a simple Java program illustrating the Bridge pattern:*/

// Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Implementor
interface Color {
    void applyColor();
}

// Concrete Implementors
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying green color");
    }
}

// Refined Abstraction
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing square - ");
        color.applyColor();
    }
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing circle - ");
        color.applyColor();
    }
}

// Client code
public class BridgeExample {
    public static void main(String[] args) {
        Color red = new RedColor();
        Color green = new GreenColor();

        Shape redSquare = new Square(red);
        redSquare.draw();

        Shape greenCircle = new Circle(green);
        greenCircle.draw();
    }
}

/* this example, Shape is the abstraction, and Color is the implementor. Concrete implementors (RedColor, GreenColor) provide different color implementations. Square and Circle are refined abstractions, which extend Shape and use a specific color through composition. The Bridge pattern allows changing or extending shapes and colors independently without having an explosion of classes. */
