package services;

import models.Room;
import java.time.Duration;
import java.time.LocalDateTime;

public class OccupancyService {
    public static void checkAndRelease(Room room) {
        if (room.isBooked() && room.getOccupants() == 0 && room.getLastOccupiedTime() != null) {
            long minutes = Duration.between(room.getLastOccupiedTime(), LocalDateTime.now()).toMinutes();
            if (minutes >= 5) {
                room.releaseBooking();
            }
        }
    }
}
