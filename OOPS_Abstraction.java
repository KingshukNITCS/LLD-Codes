abstract class Shape {

    String color;

    // these are abstract methods

    abstract double area();

    public abstract String toString();

    // abstract class can have the constructor

    public Shape(String color)

    {

        System.out.println("Shape constructor called");

        this.color = color;
    }

    // this is a concrete method

    public String getColor() { return color; }
}

class Circle extends Shape {

    double radius;

    public Circle(String color, double radius)

    {

        // calling Shape constructor

        super(color);

        System.out.println("Circle constructor called");

        this.radius = radius;
    }

    @Override double area()

    {

        return Math.PI * Math.pow(radius, 2);
    }

    @Override public String toString()

    {

        return "Circle color is " + super.getColor()

            + "and area is : " + area();
    }
}

class Rectangle extends Shape {

    double length;

    double width;

    public Rectangle(String color, double length,

                     double width)

    {

        // calling Shape constructor

        super(color);

        System.out.println("Rectangle constructor called");

        this.length = length;

        this.width = width;
    }

    @Override double area() { return length * width; }

    @Override public String toString()

    {

        return "Rectangle color is " + super.getColor()

            + "and area is : " + area();
    }
}

public class Test {

    public static void main(String[] args)

    {

        Shape s1 = new Circle("Red", 2.2);

        Shape s2 = new Rectangle("Yellow", 2, 4);

        System.out.println(s1.toString());

        System.out.println(s2.toString());
    }
}

/*
Output

Shape constructor called

Circle constructor called

Shape constructor called

Rectangle constructor called

Circle color is Red And area is : 15.205308443374602

Rectangle color is Yellow And area is : 8.0

____


Data Abstraction is the property by virtue of which only the essential details are displayed to the user. The trivial or the non-essential units are not displayed to the user. Ex: A car is viewed as a car rather than its individual components.

Data Abstraction may also be defined as the process of identifying only the required characteristics of an object ignoring the irrelevant details. The properties and behaviors of an object differentiate it from other objects of similar type and also help in classifying/grouping the objects.

Consider a real-life example of a man driving a car. The man only knows that pressing the accelerators will increase the speed of a car or applying brakes will stop the car, but he does not know how on pressing the accelerator the speed is actually increasing, he does not know about the inner mechanism of the car or the implementation of the accelerator, brakes, etc in the car. This is what abstraction is. 

In Low Level Design, abstraction is achieved by interfaces and abstract classes. We can achieve 100% abstraction using interfaces.

Abstract classes and Abstract methods :  

An abstract class is a class that is declared with an abstract keyword.
An abstract method is a method that is declared without implementation.
An abstract class may or may not have all abstract methods. Some of them can be concrete methods.
A method-defined abstract must always be redefined in the subclass, thus making overriding compulsory or making the subclass itself abstract.
Any class that contains one or more abstract methods must also be declared with an abstract keyword.
There can be no object of an abstract class. That is, an abstract class can not be directly instantiated with the new operator.
An abstract class can have parameterized constructors and the default constructor is always present in an abstract class.

 
Algorithm to implement abstraction in Low Level Design:

Determine the classes or interfaces that will be part of the abstraction.

Create an abstract class or interface that defines the common behaviors and properties of these classes.

Define abstract methods within the abstract class or interface that do not have any implementation details.

Implement concrete classes that extend the abstract class or implement the interface.

Override the abstract methods in the concrete classes to provide their specific implementations.

Use the concrete classes to implement the program logic.


When to use abstract classes and abstract methods with an example

There are situations in which we will want to define a superclass that declares the structure of a given abstraction without providing a complete implementation of every method. Sometimes we will want to create a superclass that only defines a generalization form that will be shared by all of its subclasses, leaving it to each subclass to fill in the details.

Consider a classic “shape” example, perhaps used in a computer-aided design system or game simulation. The base type is “shape” and each shape has a color, size, and so on. From this, specific types of shapes are derived(inherited)-circle, square, triangle, and so on — each of which may have additional characteristics and behaviors. For example, certain shapes can be flipped. Some behaviors may be different, such as when you want to calculate the area of a shape. The type hierarchy embodies both the similarities and differences between the shapes.


 _____

Encapsulation is data hiding(information hiding) while Abstraction is detailed hiding(implementation hiding).

While encapsulation groups together data and methods that act upon the data, data abstraction deals with exposing the interface to the user and hiding the details of implementation.

Encapsulated classes are Low Level Design classes that follow data hiding and abstraction while We can implement abstraction by using abstract classes and interfaces. 

Encapsulation is a procedure that takes place at the implementation level, while abstraction is a design-level process.


Advantages of Abstraction

It reduces the complexity of viewing things.
Avoids code duplication and increases reusability.
Helps to increase the security of an application or program as only essential details are provided to the user.
It improves the maintainability of the application. 
It improves the modularity of the application. 
The enhancement will become very easy because without affecting end-users we can able to perform any type of changes in our internal system. 
Improves code reusability and maintainability.
Hides implementation details and exposes only relevant information.
Provides a clear and simple interface to the user.
Increases security by preventing access to internal class details.
Supports modularity, as complex systems can be divided into smaller and more manageable parts.
Abstraction provides a way to hide the complexity of implementation details from the user, making it easier to understand and use.
Abstraction allows for flexibility in the implementation of a program, as changes to the underlying implementation details can be made without affecting the user-facing interface.
Abstraction enables modularity and separation of concerns, making code more maintainable and easier to debug.

 
Disadvantages of Abstraction in Low Level Design:

Abstraction can make it more difficult to understand how the system works.
It can lead to increased complexity, especially if not used properly.
May limit the flexibility of the implementation.
Abstraction can add unnecessary complexity to code if not used appropriately, leading to increased development time and effort.
Abstraction can make it harder to debug and understand code, particularly for those unfamiliar with the abstraction layers and implementation details.
Overuse of abstraction can result in decreased performance due to the additional layers of code and indirection.

Real life example of data abstraction:

A real-life example of data abstraction is a car’s dashboard. The dashboard provides a simplified interface to the driver, abstracting away the complexity of the car’s internal systems.

The dashboard provides key information such as the speed, fuel level, and engine temperature, which are necessary for the driver to operate the car safely. The driver does not need to know the intricate details of how the car’s engine or transmission work in order to drive the car. Instead, the dashboard presents a simplified, high-level view of the car’s status, allowing the driver to focus on the task of driving.

In this example, the car’s internal systems represent the underlying implementation details that are hidden from the driver. The dashboard provides the abstraction layer that simplifies the interface between the driver and the car, making it easier to operate. The abstraction layer also provides flexibility in the implementation of the car’s internal systems, allowing changes to be made without affecting the driver’s experience.

 
*/
