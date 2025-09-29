// src/commands/CancelRoomCommand.java
package commands;

import models.Room;
import services.RoomBookingService;

public class CancelRoomCommand implements Command {
    private Room room;

    public CancelRoomCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        RoomBookingService.getInstance().cancelBooking(room);
    }
}
