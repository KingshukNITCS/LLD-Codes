/*GRASP (General Responsibility Assignment Software Patterns) is a set of principles in object-oriented design that help guide the allocation of responsibilities to classes and objects. These principles aim to create designs that are flexible, reusable, and maintainable.

Here's a simple example in Java that demonstrates some of the GRASP principles:

```java*/
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class OrderProcessor {
    public void processOrder(Order order) {
        // Process the order (e.g., calculate tax, update inventory, etc.)
        double tax = calculateTax(order.getTotalPrice());
        System.out.println("Order processed for customer: " + order.getCustomerName());
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Tax: " + tax);
    }

    private double calculateTax(double totalPrice) {
        // Calculate tax based on the total price
        return totalPrice * 0.1;
    }
}

public class GRASPPrincipleExample {
    public static void main(String[] args) {
        Order order = new Order("123", "John Smith", 100.0);
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(order);
    }
}
/*```

In this example, we have an `Order` class that represents an order with properties such as `orderId`, `customerName`, and `totalPrice`. It provides accessors for retrieving the order details. 

The `OrderProcessor` class is responsible for processing orders. It has a `processOrder` method that takes an `Order` object as a parameter and performs operations such as calculating tax and printing order details.

The GRASP principles demonstrated in this example are:

1. Information Expert: The `Order` class holds the necessary information for an order, making it the expert for providing the order details.

2. Creator: In the `main` function, we create an instance of the `Order` class to represent an order.

3. Low Coupling: The `OrderProcessor` class depends only on the `Order` class and does not have direct dependencies on other classes or objects, promoting loose coupling.

4. High Cohesion: The `OrderProcessor` class has a high cohesion because it performs operations related to order processing (e.g., calculating tax) and prints order details.

5. Controller: The `main` function acts as a controller, creating the necessary objects and invoking methods to initiate the order processing flow.

By following these GRASP principles, we create a design that distributes responsibilities effectively, ensures loose coupling between classes, and promotes maintainable and flexible code.
  */
