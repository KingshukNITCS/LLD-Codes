/* Demystifying Copy Constructors in Java and C++

In object-oriented programming, creating a copy of an existing object is a common operation. This article explains what copy constructors are and how they can be implemented in Java and C++. We’ll walk through examples to understand the importance and usage of copy constructors in both languages.

What is a Copy Constructor?

A copy constructor is a special constructor in a class that is used to make a copy of an existing object. It takes an object of the same class as a parameter and initializes the new object with the values of the passed object.

Copy Constructor in C++

In C++, a copy constructor is an important tool, mainly because C++ allows direct access to memory and direct manipulation of data members.

Let's take a look at an example:*/



/* Copy Constructor in Java

In Java, a copy constructor is not as critical as in C++, since Java does not allow direct access to memory. However, it is still a useful concept especially when dealing with mutable objects.*/

class Point {
    int x, y;

    // Constructor
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    Point(Point p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    void display()
    {
        System.out.println("x: " + x + ", y: " + y);
    }
}

public class Main {
    public static void main(String[] args)
    {
        Point p1 = new Point(10, 20);
        // Using the copy constructor to create a new point
        // that is a copy of p1
        Point p2 = new Point(p1);

        // Display the values of p1 and p2
        p1.display();
        p2.display();
    }
}

/* 
We have a Point class with a copy constructor that initializes a new Point object with the values from an existing Point object.

When to use Copy Constructors

Copy constructors are useful in several scenarios:

Deep copy: When you need to create a new object that is a copy of an existing object with its own memory allocation.
Conversions: Sometimes, you might need to create an object of one class from an object of another class that has similar data.
 

*/
