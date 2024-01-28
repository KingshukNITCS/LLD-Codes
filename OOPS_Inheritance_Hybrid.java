class SolarSystem {
}

class Earth extends SolarSystem {
}

class Mars extends SolarSystem {
}

public class Moon extends Earth {

    public static void main(String args[])

    {

        SolarSystem s = new SolarSystem();

        Earth e = new Earth();

        Mars m = new Mars();

        System.out.println(s instanceof SolarSystem);

        System.out.println(e instanceof Earth);

        System.out.println(m instanceof SolarSystem);
    }
}

/*

Inheritance is an important pillar of OOP(Object-Oriented Programming). It is the mechanism in Low Level Design by which one class is allowed to inherit the features(fields and methods) of another class. In Low Level Design, Inheritance means creating new classes based on existing ones. A class that inherits from another class can reuse the methods and fields of that class. In addition, you can add new fields and methods to your current class as well.  

Why Do We Need Low Level Design Inheritance?

Code Reusability: The code written in the Superclass is common to all subclasses. Child classes can directly use the parent class code.

Method Overriding: Method Overriding is achievable only through Inheritance. It is one of the ways by which Low Level Design achieves Run Time 

Polymorphism.

Abstraction: The concept of abstract where we do not have to provide all details is achieved through inheritance. Abstraction only shows the functionality to the user.

Important Terminologies Used in Low Level Design Inheritance

Class: Class is a set of objects which shares common characteristics/ behavior and common properties/ attributes. Class is not a real-world entity. It is just a template or blueprint or prototype from which objects are created.

Super Class/Parent Class: The class whose features are inherited is known as a superclass(or a base class or a parent class).

Sub Class/Child Class: The class that inherits the other class is known as a subclass(or a derived class, extended class, or child class). The subclass can add its own fields and methods in addition to the superclass fields and methods.

Reusability: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want, we can derive our new class from the existing class. By doing this, we are reusing the fields and methods of the existing class.

How to Use Inheritance in Low Level Design?

The extends keyword is used for inheritance in Low Level Design. Using the extends keyword indicates you are derived from an existing class. In other words, “extends” refers to increased functionality.

Syntax : 

class derived-class extends base-class  

{  

   //methods and fields  

}  


In subclasses we can inherit members as is, replace them, hide them, or supplement them with new members: The inherited fields can be used directly, just like any other fields.We can declare new fields in the subclass that are not in the superclass.The inherited methods can be used directly as they are.We can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it (as in the example above, toString() method is overridden).We can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.

We can declare new methods in the subclass that are not in the superclass.We can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.

Advantages Of Inheritance in Low Level Design:

Code Reusability: Inheritance allows for code reuse and reduces the amount of code that needs to be written. The subclass can reuse the properties and methods of the superclass, reducing duplication of code.
 

Abstraction: Inheritance allows for the creation of abstract classes that define a common interface for a group of related classes. This promotes abstraction and encapsulation, making the code easier to maintain and extend.

Class Hierarchy: Inheritance allows for the creation of a class hierarchy, which can be used to model real-world objects and their relationships.

Polymorphism: Inheritance allows for polymorphism, which is the ability of an object to take on multiple forms. Subclasses can override the methods of the superclass, which allows them to change their behavior in different ways.

Disadvantages of Inheritance in Low Level Design:

Complexity: Inheritance can make the code more complex and harder to understand. This is especially true if the inheritance hierarchy is deep or if multiple inheritances are used.

Tight Coupling: Inheritance creates a tight coupling between the superclass and subclass, making it difficult to make changes to the superclass without affecting the subclass.

Conclusion

Default superclass: Except Object class, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of the Object class.

Superclass can only be one: A superclass can have any number of subclasses. But a subclass can have only one superclass. This is because Low Level Design does not support multiple inheritances with classes. Although with interfaces, multiple inheritance is supported by Low Level Design.

Inheriting Constructors: A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.

Private member inheritance: A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods(like getters and setters) for accessing its private fields, these can also be used by the subclass.

FAQs in Inheritance

1. What is Inheritance Low Level Design?

Inheritance is a concept of OOPs where one class inherits from another class that can reuse the methods and fields of the parent class.

2. What are the 4 types of inheritance in Low Level Design?

There are Single, Multiple, Multilevel, and Hybrid.

3. What is the use of extend keyword?

Extend keyword is used for inheriting one class into another.

4. What is an example of inheritance in Low Level Design?

A real-world example of Inheritance in Low Level Design is mentioned below:

Consider a group of vehicles. You need to create classes for Bus, Car, and Truck. The methods fuelAmount(), capacity(), applyBrakes() will be the same for all three classes. This is Inheritance.


*/
