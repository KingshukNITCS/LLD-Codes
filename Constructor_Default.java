class Dog {
    String name;
    int age;

    Dog()
    {
        name = "Unknown";
        age = 0;
        System.out.println("Default constructor called");
    }

    void display()
    {
        System.out.println("Name: " + name
                           + ", Age: " + age);
    }

    public static void main(String[] args)
    {
        Dog dog1 = new Dog();
        dog1.display();
    }
}

/*
Constructors are a crucial aspect of object-oriented programming as they help in initializing the objects with a valid state. In both C++ and Java, constructors play a similar role, and the syntax is fairly analogous.

Default constructors allow objects to be initialized with default values without any user input.
Parameterized constructors, on the other hand, allow for initialization of objects with specific values.
Using constructors effectively can lead to more robust code, as it ensures that an object is properly initialized when it's created.

Remember that if you don't provide any constructor in Java, the compiler will create a default constructor for you. In contrast, in C++, the compiler-generated constructor is created only if you don't provide any constructor.

Lastly, constructors can also be overloaded, which means a class can have more than one constructor, each with a different number or type of parameters. This gives you more flexibility in how you can create objects of your classes.

In practice, constructors are often used to provide greater control over how an object should be initialized and ensure that they are set up properly before being used. This is essential for creating reliable and maintainable object-oriented applications in both C++ and Java.



*/
