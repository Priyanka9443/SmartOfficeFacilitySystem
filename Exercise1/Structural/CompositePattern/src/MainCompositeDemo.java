



public class MainCompositeDemo {

    public static void main(String[] args) {

        // Individual devices
        DeviceLeaf light1 = new DeviceLeaf("Light 1");
        DeviceLeaf thermostat1 = new DeviceLeaf("Thermostat 1");
        DeviceLeaf doorLock1 = new DeviceLeaf("Door Lock 1");

        // Composite for a room
        DeviceComposite room1 = new DeviceComposite("Room 1");
        room1.add(light1);
        room1.add(thermostat1);
        room1.add(doorLock1);

        // Composite for whole floor
        DeviceComposite floor1 = new DeviceComposite("Floor 1");
        floor1.add(room1);

        // Show hierarchy
        System.out.println("Device Hierarchy:");
        floor1.showDetails();

        System.out.println("\nTurning ON all devices:");
        floor1.turnOn();

        System.out.println("\nTurning OFF all devices:");
        floor1.turnOff();
    }
}
