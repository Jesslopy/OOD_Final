//composite


import java.util.ArrayList;
import java.util.List;

public class Division implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Division(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder("Division: " + name + "\n");
        for (Component component : components) {
            sb.append(component.display()).append("\n");
        }
        return sb.toString();
    }
}