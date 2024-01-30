/*

A strategy pattern is a behavioural design pattern that allows the behaviour of an object to be selected at runtime. It is one of the Gang of Four (GoF) design patterns, which are widely used in object-oriented programming. Let's understand first the need of the strategy pattern using an example. 

In the below example, we are using  if-else statement to handle the method of the payment for the processPayment Method of the class Payment, which is not a good choice for the optimal design pattern, whenever we need to add new payment method we need to add new if-else statement this thing violates the open closed principles, that's why this is not an optimal move for the design pattern. 

Use Case 1: Sorting Algorithms

In a software system, you may need to sort an array or a list of objects. There are several sorting algorithms available, such as QuickSort, MergeSort, BubbleSort, etc., each having its advantages and disadvantages, and their performance can vary depending upon the data. Here, the Strategy pattern can be utilized. We can create a SortStrategy interface with a sort() method and multiple sorting algorithms implementing this interface. The context class, which uses the sorting algorithm, would have a reference to the SortStrategy interface, allowing the client to change the sorting strategy at runtime.

Use Case 2: Compression Algorithms

Suppose you are building a file compression utility that can perform various types of compression like ZIP, RAR, or TAR. In this scenario, you can implement a CompressionStrategy interface that has a compress() method, and the different compression algorithms (ZIP, RAR, TAR) can be implemented as separate classes inheriting from the CompressionStrategy interface. The client can choose the required compression strategy without modifying the existing code, and you can also add new compression strategies in the future without affecting the client code.

Use Case 3: Payment Strategies

Let's consider an e-commerce application where multiple payment strategies such as credit card, PayPal, and digital wallets like Google Pay or Apple Pay are implemented. A PaymentStrategy interface can be created with a pay(amount) method. Different payment methods can be separate classes implementing this interface. In the checkout process, the client can choose the appropriate payment strategy without any change in the client code. This will also allow for easy addition of new payment strategies in the future.
Violating OCP & SRP

import java.io.*;

class Payment {

    public void processPayment(String paymentMethod)
    {

        if ("UPI".equals(paymentMethod)) {

            System.out.println("Payment is done by UPI");
        }

        else

            if ("CARD".equals(paymentMethod)) {

            System.out.println("Payment is done by CARD");
        }
    }
}
In order to make the above code optimal, we will use the Startegy Design pattern, Let's understand the Startegy Design pattern in the above example. 

*/

interface PaymentStartegy {

    public void processPayment();
}

class PaymentByCard implements PaymentStartegy {

    public void processPayment()
    {

        System.out.println("Payment is done by Card");
    }
}

class PaymentByUPI implements PaymentStartegy {

    public void processPayment()
    {

        System.out.println("Payment is done by UPI");
    }
}

class paymentService {

    PaymentStartegy paymentStartegy;

    paymentService(PaymentStartegy paymentStartegy)
    {

        this.paymentStartegy = paymentStartegy;
    }

    public void processOrder()
    {

        this.paymentStartegy.processPayment();
    }
  
   public static void main(String args[]){
 
    paymentService first=new paymentService(new PaymentByUPI());
    
    paymentService second=new paymentService(new PaymentByCard());
    
    first.processOrder();
  }
 }

/*Whenever we need to add new payment method we don't need to change the paymentService class instead of this we can create another class that implements the paymentStartegy, and write the implementation of the processPayment() method, and we can easily access the method in the paymentService class*/
