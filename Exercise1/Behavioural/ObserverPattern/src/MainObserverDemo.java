public class MainObserverDemo {
    public static void main(String[] args) {
        Room room = new Room();
        Light light = new Light();

        room.attach(light);

        room.setStatus("Occupied");  // triggers Light ON
        room.setStatus("Empty");     // triggers Light OFF
    }
}
