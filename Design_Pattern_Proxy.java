/* Proxy design pattern provides a surrogate or placeholder for another object to control access to it. Here's a simple Java program illustrating the Proxy pattern:*/

// Subject interface
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // Image will be loaded and displayed only when 'display' is called
        image.display();
    }
}

/*this example, Image is the subject interface, RealImage is the real subject implementing Image, and ProxyImage is the proxy class. The proxy delays the creation and initialization of the RealImage object until the display method is called. This can be useful in scenarios where creating the real object is resource-intensive, and you want to control when it is actually needed
*/ 
