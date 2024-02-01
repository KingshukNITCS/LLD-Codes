/* In a real Java backend development use case, consider a scenario where you want to represent a hierarchical structure of components, and you need to treat individual objects and compositions of objects uniformly. The Composite design pattern is suitable for this. Here's a simplified example: */

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void process();
}

// Leaf class implementing the Component interface
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void process() {
        System.out.println("Processing leaf: " + name);
    }
}

// Composite class implementing the Component interface
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void process() {
        System.out.println("Processing composite");
        for (Component component : components) {
            component.process();
        }
    }
}

// Client code in a real backend development scenario
public class CompositeBackendExample {
    public static void main(String[] args) {
        // Building a composite structure
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        Composite composite = new Composite();
        composite.addComponent(leaf1);
        composite.addComponent(leaf2);

        Component leaf3 = new Leaf("Leaf 3");

        Composite compositeWithLeaf3 = new Composite();
        compositeWithLeaf3.addComponent(composite);
        compositeWithLeaf3.addComponent(leaf3);

        // Processing the composite structure uniformly
        compositeWithLeaf3.process();
    }
}

/*
In this example, Component is the interface representing both leaf and composite elements. Leaf is a concrete class representing individual objects, and Composite is a concrete class representing compositions of objects. The key idea is that both leaf and composite implement the same interface, allowing you to treat them uniformly. This is useful in scenarios where you need to work with a hierarchy of objects, such as representing a tree-like structure in a backend application.
*/
