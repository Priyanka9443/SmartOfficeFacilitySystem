public class DeviceFactory {
    public static Device createDevice(String type) {
        switch(type) {
            case "Light": return new Light();
            default: return null;
        }
    }
}