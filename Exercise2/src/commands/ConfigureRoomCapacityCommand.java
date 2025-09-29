// src/commands/ConfigureRoomCapacityCommand.java
package commands;

import config.OfficeConfiguration;

public class ConfigureRoomCapacityCommand implements Command {
    private int roomId;
    private int capacity;

    public ConfigureRoomCapacityCommand(int roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
    }

    @Override
    public void execute() {
        OfficeConfiguration.getInstance().setRoomCapacity(roomId, capacity);
    }
}
