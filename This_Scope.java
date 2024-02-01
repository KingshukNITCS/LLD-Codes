/* 'this' in Java

In Java, this is a reference variable that refers to the current object.

Use cases in Java:

1. To Resolve Scope Ambiguity

Similar to C++, this can be used to resolve the ambiguity between class fields and parameters.

java*/

class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    int getArea() { return this.length * this.breadth; }
}

public class Main {
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Area of the rectangle is: "
                           + rect.getArea());
    }
}
