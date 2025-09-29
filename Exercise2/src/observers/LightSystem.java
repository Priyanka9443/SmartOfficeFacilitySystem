package observers;

import models.Room;

public class LightSystem implements Observer {
    private boolean on = false;

    @Override
    public void update(Room room) {
        if (room.getOccupants() > 0) {
            if (!on) {
                System.out.println("Lights turned ON for Room " + room.getId());
                on = true;
            }
        } else {
            if (on) {
                System.out.println("Lights turned OFF for Room " + room.getId());
                on = false;
            }
        }
    }
}
