class Dog {
    String name;
    int age;

    Dog(String dogName, int dogAge)
    {
        name = dogName;
        age = dogAge;
        System.out.println(
            "Parameterized constructor called");
    }

    void display()
    {
        System.out.println("Name: " + name
                           + ", Age: " + age);
    }

    public static void main(String[] args)
    {
        Dog dog1 = new Dog("Buddy", 3);
        dog1.display();
    }
}
