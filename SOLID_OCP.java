/*The Open-Closed Principle (OCP) is a fundamental principle in object-oriented programming that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the behavior of a class should be easily extendable without modifying its source code.

Here's a simple example in Java that demonstrates the Open-Closed Principle:

```java*/
interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    public double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

public class OpenClosedPrincipleExample {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle(5, 4);
        shapes[1] = new Circle(3);

        AreaCalculator areaCalculator = new AreaCalculator();
        double totalArea = areaCalculator.calculateTotalArea(shapes);
        System.out.println("Total area: " + totalArea);
    }
}
/*
```

In this example, we have the `Shape` interface that defines a `calculateArea` method. The `Rectangle` and `Circle` classes implement this interface and provide their own implementations of the `calculateArea` method.

The `AreaCalculator` class has a method `calculateTotalArea` that takes an array of `Shape` objects and calculates the total area by iterating over each shape and calling its `calculateArea` method.

In the `main` function, we create an array of two `Shape` objects, a `Rectangle` and a `Circle`. We pass this array to the `calculateTotalArea` method of the `AreaCalculator` class, which correctly calculates the total area without modifying any existing code.

This example demonstrates the Open-Closed Principle because the behavior of the `AreaCalculator` class can be extended to calculate the area of new shapes (such as adding a `Triangle` class) without modifying the `AreaCalculator` class itself. The `Shape` interface and its implementations are open for extension, allowing new shapes to be easily added, while the `AreaCalculator` class is closed for modification, ensuring that existing code remains unchanged.

By adhering to the Open-Closed Principle, our code becomes more flexible, maintainable, and less prone to bugs when new requirements or changes arise.

*/
