interface BookI
{
    public void name();
}

abstract class Book
{ 
    String name;
    public abstract void name();
}

class HarryPotter extends Book
{
    //String name;
    HarryPotter()
    {
       name = "Harry Potter";
    }
    @Override
    public void name()
    {
       System.out.print(name);
    }
}

class Twilight extends Book
{
    //String name;
    Twilight()
    {
       name = "Twilight";
    }
    @Override
    public void name()
    {
       System.out.print(name);
    }
}

class DisplayBook
{
     Book book;
     DisplayBook(Book book)
     {
         this.book=book;
     }
     void display()
     {
         book.name();
     }
}


public class Main {
    public static void main(String[] args) {
        DisplayBook displaybook = new DisplayBook(new HarryPotter());
        displaybook.display();
    }
}


