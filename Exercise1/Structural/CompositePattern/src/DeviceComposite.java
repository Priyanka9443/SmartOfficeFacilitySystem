


import java.util.ArrayList;
import java.util.List;

public class DeviceComposite extends DeviceComponent {

    private List<DeviceComponent> children = new ArrayList<>();

    public DeviceComposite(String name) {
        super(name);
    }

    public void add(DeviceComponent component) {
        children.add(component);
    }

    public void remove(DeviceComponent component) {
        children.remove(component);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON composite: " + name);
        for (DeviceComponent c : children) {
            c.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF composite: " + name);
        for (DeviceComponent c : children) {
            c.turnOff();
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Composite Device: " + name);
        for (DeviceComponent c : children) {
            c.showDetails();
        }
    }
}
