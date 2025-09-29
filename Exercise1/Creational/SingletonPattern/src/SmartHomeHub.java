public class SmartHomeHub {
    private static SmartHomeHub instance = null;
    private SmartHomeHub() {}
    public static SmartHomeHub getInstance() {
        if (instance == null) instance = new SmartHomeHub();
        return instance;
    }
    public void showStatus() { 
        System.out.println("Smart Home Hub is running"); }
}