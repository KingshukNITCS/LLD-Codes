public class Dog {

    // Instance Variables

    String name;

    String breed;

    int age;

    String color;

    // Constructor Declaration of Class

    public Dog(String name, String breed, int age, String color)

    {

        this.name = name;

        this.breed = breed;

        this.age = age;

        this.color = color;
    }

    // methods

    public String getName() { return name; }

    public String getBreed() { return breed; }

    public int getAge() { return age; }

    public String getColor() { return color; }

    @Override

    public String toString()

    {

        return ("Hi my name is " + this.getName() +

                ".\nMy breed, age and color are "
                + this.getBreed()

                + ", " + this.getAge() + ", "
                + this.getColor());
    }

    public static void main(String[] args)

    {

        Dog wuffy = new Dog("wuffy", "papillon", 5, "white");

        System.out.println(wuffy.toString());
    }
  }

/*

Output: 

Hi my name is wuffy.
My breed, age and color are papillon, 5, white
 
This class contains a single constructor. We can recognize a constructor because its declaration uses the same name as the class and it has no return type. The Java compiler differentiates the constructors based on the number and the type of the arguments. The constructor in the Dog class takes four arguments. The following statement provides “tuffy”, “papillon”, 5, “white” as values for those arguments:

Dog tuffy = new Dog("wuffy", "papillon", 5, "white");

*/
