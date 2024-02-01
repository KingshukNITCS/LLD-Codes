/* To Call Another Constructor in the Same Class

In Java, this can be used to call one constructor from another in the same class.

java */

class Box {
    int length, breadth, height;

    // Default constructor
    Box()
    {
        this(1, 1, 1); // calls parameterized constructor
    }

    // Parameterized constructor
    Box(int length, int breadth, int height)
    {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    int getVolume() { return length * breadth * height; }
}

public class Main {
    public static void main(String[] args)
    {
        Box defaultBox = new Box();
        System.out.println("Volume of default box: "
                           + defaultBox.getVolume());
        Box customBox = new Box(2, 3, 4);
        System.out.println("Volume of custom box: "
                           + customBox.getVolume());
    }
}
