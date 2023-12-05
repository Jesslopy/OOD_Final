//Composite used for Kingdom Hierarchy



public interface Component {
    void add(Component component);
    void remove(Component component);
    String display();
}