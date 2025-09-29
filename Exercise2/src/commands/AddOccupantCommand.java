// src/commands/AddOccupantCommand.java
package commands;

import models.Room;

public class AddOccupantCommand implements Command {
    private Room room;
    private int count;

    public AddOccupantCommand(Room room, int count) {
        this.room = room;
        this.count = count;
    }

    @Override
    public void execute() {
        room.addOccupants(count);
    }
}
