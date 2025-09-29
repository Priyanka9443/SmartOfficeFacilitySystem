public class DeviceProxy extends Device {
    private Device realDevice;

    public DeviceProxy(Device device) 
    { this.realDevice = device; 
    }
    
    @Override 

    public void turnOn() {
        System.out.println("Logging: Turning on device");
        realDevice.turnOn();
    }
}