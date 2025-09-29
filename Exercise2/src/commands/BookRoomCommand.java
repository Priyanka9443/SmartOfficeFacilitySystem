// src/commands/BookRoomCommand.java
package commands;

import models.Room;
import services.RoomBookingService;

public class BookRoomCommand implements Command {
    private Room room;
    private String startTime;
    private int duration;

    public BookRoomCommand(Room room, String startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        RoomBookingService.getInstance().bookRoom(room, startTime, duration);
    }
}
