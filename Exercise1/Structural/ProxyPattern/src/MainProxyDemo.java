public class MainProxyDemo {
    public static void main(String[] args) {
        Device light = new Light();
        Device proxy = new DeviceProxy(light);
        proxy.turnOn();
        
    }
}