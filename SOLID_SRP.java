/* Single Responsibility Principle: This principle states that “a class should have only one reason to change” which means every class should have a single responsibility or single job or single purpose. Take the example of developing software. The task is divided into different members doing different things as front-end designers do design, the tester does testing and backend developer takes care of backend development part then we can say that everyone has a single job or responsibility.


Most of the time it happens that when programmers have to add features or new behavior they implement everything into the existing class which is completely wrong. It makes their code lengthy, complex and consumes time when later something needs to be modified. Use layers in your application and break God classes into smaller classes or modules.


As the name suggests, the Single Responsibility principle states 2 key principles.

Your class or method should have only one reason to change.

Your class or method should have only one responsibility to take care of.

So what does that mean actually? While you design your logic in either class or method, you should not be writing all kinds of responsibilities in one place. This will make your code quite complex and unmanageable. It will also be difficult to adjust new changes later as there are high chances it will affect the other functionality and you will end up testing all the functionalities even though it is a smaller change. Let’s take the example below.


public class Invoice
{
            public void AddInvoice()
            { 
                // your logic
            }


            public void DeleteInvoice()
            { 
                // your logic
            }


            public void GenerateReport()
            { 
                // your logic
            }


            public void EmailReport()
            { 
                // your logic
            }
}

 

The class Invoice consists of 4 different methods – AddInvoice(), DeleteInvoice(), GenerateReport(), EmailReport(). As the single responsibility principle says, your class or method should have only one responsibility and only one reason to change, now let’s find out whether the above example satisfies the conditions. If we take a look at the methods, each has a single responsibility. For e.g. The AddInvoice() method is only responsible for adding an invoice to the system, DeleteInvoice() method is only responsible for deleting invoices,s and likewise for GenerateReport() and EmailReport() methods. We can say that methods do satisfy the single responsibility principle. But if you take a look at Invoice class, it is now taking care of multiple responsibilities which are not satisfying the single responsibility principle. So in order to satisfy the single responsibility principle for class Invoice, we will divide the methods into different classes where one class will take care of only one responsibility.


 We are going to club methods AddInvoice() and DeleteInvoice() into single class Invoice as they do a similar kind of functionality. Whereas we will be creating separate classes Report and Email for methods GenerateReport() and EmailReport() respectively as they are completely independent and have different functionality. 

 */

public class Invoice
{
            public void AddInvoice()
            {
                // your logic
            }


            public void DeleteInvoice()
            {
                // your logic
            }
}


public class Report
{


            public void GenerateReport()
            {
                // your logic
            }
}


public class Email
{
            public void EmailReport()
            {
                // your logic
            }
}
/*
That’s it! Now each class is responsible to take care of only one responsibility and only one reason to change. The code is now ever smaller and manageable for each functionality and you won’t be required to test the complete functionality of each class if the change is happening for any one of the classes.


 

As the name indicates, it states that all classes and modules should have only 1 well-defined responsibility. As per Robert C Martin, 

A class should have one, and only one reason to change.

This means when we design our classes, we need to ensure that our class is responsible only for 1 task or functionality and when there is a change in that task/functionality, only then, that class should change.

In the world of software, change is the only constant factor. When requirements change and when our classes do not adhere to this principle, we would be making too many changes to our classes to make our classes adaptable to the new business requirements. This could involve lots of side effects, retesting, and introducing new bugs. Also, our dependent classes need to change, thereby recompiling the classes and changing test cases. Thus, the whole application will need to be retested to ensure that new functionality did not break the existing working code.

Generally in long-running software applications, as and when new requirements come up, developers are tempted to add new methods and functionality to the existing code which makes the classes bloated and hard to test and understand.  It is always a good practice to look into the existing classes and see if the new requirements fit into the existing class or should there be a new class designed for the same.

Benefits of Single Responsibility Principle

When an application has multiple classes, each of them following this principle, then the applicable becomes more maintainable, easier to understand.
The code quality of the application is better, thereby having fewer defects.
Onboarding new members are easy, and they can start contributing much faster.
Testing and writing test cases is much simpler
Examples

In the java world, we have a lot of frameworks that follow this principle. JSR 380 validation API is a good example that follows this principle. It has annotations like @NotNull, @Max, @Min, @Size which are applied to the bean properties to ensure that the bean attributes meet the specific criteria. Thus, the validation API has just 1 responsibility of applying validation rules on bean properties and notifying with error messages when the bean properties do not match the specific criteria

Another example is Spring Data JPA which takes care of all the CRUD operations.  It has one responsibility of defining a standardized way to store, retrieve entity data from persistent storage. It eases development effort by removing the tedious task of writing boilerplate JDBC code to store entities in a database.

Spring Framework in general, is also a great example of Single Responsibility in practice.  Spring framework is quite vast, with many modules – each module catering to one specific responsibility/functionality. We only add relevant modules in our dependency pom based on our needs.

 
*/




  
