public class MainSingletonDemo {
    public static void main(String[] args) {
        SmartHomeHub hub = SmartHomeHub.getInstance();
        hub.showStatus(); 
    }
}