



public abstract class DeviceComponent {
    protected String name;

    public DeviceComponent(String name) {
        this.name = name;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void showDetails();
}
