/*DRY (Don't Repeat Yourself) and KISS (Keep It Simple, Stupid) are principles in software development that promote simplicity, maintainability, and code reusability. Let's explore them using a simple Java program:

```java*/
class Shape {
    protected double area;

    public Shape(double area) {
        this.area = area;
    }

    public void displayArea() {
        System.out.println("Area: " + area);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super(length * width);
        this.length = length;
        this.width = width;
    }

    public void displayDimensions() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(Math.PI * radius * radius);
        this.radius = radius;
    }

    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }
}

public class DryKissPrincipleExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        rectangle.displayDimensions();
        rectangle.displayArea();

        Circle circle = new Circle(2.5);
        circle.displayRadius();
        circle.displayArea();
    }
}
/*```

In this example, we have two classes, `Rectangle` and `Circle`, which are subclasses of the `Shape` class. The `Shape` class represents a generic shape with an `area` property and a `displayArea` method to print the area.

DRY (Don't Repeat Yourself) Principle:
- The DRY principle suggests avoiding duplication of code. We can observe that the calculation of the area is performed in the constructors of both the `Rectangle` and `Circle` classes, eliminating code duplication. By calculating the area in the superclass constructor and storing it in the `area` variable, we can reuse the `displayArea` method without repeating the calculation logic.

KISS (Keep It Simple, Stupid) Principle:
- The KISS principle emphasizes simplicity and avoiding unnecessary complexity. In this example, the classes have straightforward and simple implementations. The `Rectangle` class has a `displayDimensions` method to print its length and width, while the `Circle` class has a `displayRadius` method to print its radius. Both classes inherit the `displayArea` method from the `Shape` superclass. The code is kept simple, readable, and easy to understand.

By adhering to the DRY and KISS principles, we eliminate code duplication, promote code reuse, and maintain simplicity in the design. This leads to cleaner and more maintainable code that is easier to understand and modify.*/
