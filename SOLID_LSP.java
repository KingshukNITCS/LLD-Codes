/*The Liskov Substitution Principle (LSP) is a principle in object-oriented programming that states that objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program. In other words, a subclass should be able to be substituted for its superclass without breaking the behavior expected by the client code.

Here's a simple example in Java that demonstrates the Liskov Substitution Principle:

```java*/
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

public class LiskovSubstitutionPrincipleExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(5);
        System.out.println("Square area: " + square.calculateArea());
    }
}
/*```

In this example, we have a `Rectangle` class that has width and height properties and provides methods to set the width and height, as well as calculate the area based on these dimensions.

The `Square` class is a subclass of `Rectangle` and overrides the `setWidth` and `setHeight` methods to ensure that both width and height are always equal. This is because a square has the same width and height.

In the `main` function, we create an instance of `Rectangle` and set its width and height to 5 and 4, respectively, and calculate its area. Then, we create an instance of `Square` and set its width and height to 5, and calculate its area.

The important aspect here is that the `Square` class is substituting the `Rectangle` class in the `square` variable. Even though `Square` is a subclass of `Rectangle` and has different behavior for setting the width and height, it still adheres to the Liskov Substitution Principle because it can be used in place of the `Rectangle` class without affecting the correctness of the program. The client code treats the `square` object as a `Rectangle` and calculates its area correctly.

By following the Liskov Substitution Principle, we ensure that our code is more flexible, reusable, and maintainable. It allows us to write code that is based on abstractions and promotes polymorphism, enabling us to substitute objects of subclasses for objects of their superclass without introducing unexpected behaviors.
*/
