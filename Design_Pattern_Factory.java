/*The Factory design pattern is a creational pattern that provides an interface for creating objects but delegates the actual object creation to subclasses. This pattern allows for object creation without specifying the exact class of the object being created. Here's a simple Java program that demonstrates the Factory design pattern:

```java*/
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape rectangle = shapeFactory.createShape("rectangle");
        rectangle.draw();

        Shape circle = shapeFactory.createShape("circle");
        circle.draw();
    }
}
/*```

In this example, we have an interface called `Shape` which defines the common behavior for different shapes. The `Rectangle` and `Circle` classes implement this interface and provide their respective implementations for the `draw` method.

The `ShapeFactory` class acts as the factory, responsible for creating objects of different shapes based on the input provided. It has a `createShape` method that takes a `shapeType` parameter and returns the corresponding shape object. The factory method uses conditional statements to determine the type of shape to create.

In the `main` method, we create an instance of the `ShapeFactory` and use it to create `Rectangle` and `Circle` objects. We then call the `draw` method on these objects, which is implemented differently in each shape class.

The Factory design pattern allows us to create objects without exposing the instantiation logic to the client. It provides a single entry point, the factory method, to create objects based on the input provided. This promotes loose coupling and simplifies object creation, making it easier to extend the code in the future by adding new shapes without modifying existing client code.
*/
