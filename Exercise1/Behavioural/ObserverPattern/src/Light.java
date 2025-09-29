public class Light implements Observer {
    @Override
    public void update(String status) {
        if (status.equals("Occupied")) {
            System.out.println("Light ON - Room Occupied");
        } else {
            System.out.println("Light OFF - Room Empty");
        }
    }
}
