package observers;

import models.Room;

public class AirConditioningSystem implements Observer {
    private boolean on = false;

    @Override
    public void update(Room room) {
        if (room.getOccupants() > 0) {
            if (!on) {
                System.out.println("AC turned ON for Room " + room.getId());
                on = true;
            }
        } else {
            if (on) {
                System.out.println("AC turned OFF for Room " + room.getId());
                on = false;
            }
        }
    }
}
