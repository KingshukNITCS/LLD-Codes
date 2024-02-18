/*The Builder pattern is a creational design pattern that is used to construct complex objects step by step. It allows you to create objects with a large number of parameters in a more readable and manageable way.

Here's a simple Java program demonstrating the Builder pattern:

```java*/
// Product class
class Pizza {
    private String dough;
    private String sauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    public Pizza(String dough, String sauce, boolean cheese, boolean pepperoni, boolean mushrooms) {
        this.dough = dough;
        this.sauce = sauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
    }

    // Getter methods
    // Setter methods (optional)
    // Other pizza-related methods
}

// Builder class
class PizzaBuilder {
    private String dough;
    private String sauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    public PizzaBuilder() {
    }

    public PizzaBuilder withDough(String dough) {
        this.dough = dough;
        return this;
    }

    public PizzaBuilder withSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder withCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder withPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
        return this;
    }

    public PizzaBuilder withMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
        return this;
    }

    public Pizza build() {
        return new Pizza(dough, sauce, cheese, pepperoni, mushrooms);
    }
}

// Client class
public class Main {
    public static void main(String[] args) {
        // Create a pizza using the Builder pattern
        Pizza pizza = new PizzaBuilder()
                .withDough("Thin crust")
                .withSauce("Tomato")
                .withCheese(true)
                .withPepperoni(true)
                .build();

        // Now, you have a pizza object created with the desired attributes
    }
}
/*```

In this example:

- `Pizza` is the product class that we want to build.
- `PizzaBuilder` is the builder class that provides methods to set each attribute of the pizza.
- The `PizzaBuilder` class has a `build()` method that constructs and returns the final `Pizza` object with the specified attributes.
- In the `Main` class, we create a pizza using the builder by chaining the setter methods to set the desired attributes, and then calling the `build()` method to get the constructed pizza object.

This allows for a more readable and flexible way to construct objects, especially when dealing with a large number of optional parameters.*/
