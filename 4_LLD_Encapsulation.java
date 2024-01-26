class Person {

    private String name;

    private int age;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}

public class Main {

    public static void main(String[] args)

    {

        Person person = new Person();

        person.setName("John");

        person.setAge(30);

        System.out.println("Name: " + person.getName());

        System.out.println("Age: " + person.getAge());
    }
}

/*

Output

Name: John

Age: 30

Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates. Another way to think about encapsulation is that it is a protective shield that prevents the data from being accessed by the code outside this shield. 

*/
