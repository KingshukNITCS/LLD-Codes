/* Flyweight design pattern is used to minimize memory usage or computational expenses by sharing as much as possible with related objects. Here's a simple example in Java:*/

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Shape {
    void draw();
}

// Concrete Flyweight class
class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle");
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        if (!circleMap.containsKey(color)) {
            Circle circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating a new " + color + " circle");
            return circle;
        } else {
            System.out.println("Reusing existing " + color + " circle");
            return circleMap.get(color);
        }
    }
}

// Client code
public class FlyweightExample {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle("Red");
        redCircle.draw();

        Shape greenCircle = ShapeFactory.getCircle("Green");
        greenCircle.draw();

        Shape anotherRedCircle = ShapeFactory.getCircle("Red");
        anotherRedCircle.draw();
    }
              }

/*
this example, the Circle class is the concrete flyweight, and the ShapeFactory is the flyweight factory. The factory maintains a pool of flyweight objects (circleMap), and when a client requests a circle with a specific color, the factory either creates a new one or returns an existing one from the pool. This way, memory is saved by reusing existing objects when possible.

*/
