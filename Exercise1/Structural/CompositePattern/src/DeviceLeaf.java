


public class DeviceLeaf extends DeviceComponent {

    public DeviceLeaf(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " turned OFF");
    }

    @Override
    public void showDetails() {
        System.out.println("Device: " + name);
    }
}
