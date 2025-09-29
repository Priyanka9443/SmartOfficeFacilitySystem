public class MainFactoryDemo {
    public static void main(String[] args) {
        Device d = DeviceFactory.createDevice("Light");
        d.turnOn(); 
    }
}