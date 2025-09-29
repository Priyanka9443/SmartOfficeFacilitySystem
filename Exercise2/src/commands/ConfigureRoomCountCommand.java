// src/commands/ConfigureRoomCountCommand.java
package commands;

import config.OfficeConfiguration;

public class ConfigureRoomCountCommand implements Command {
    private int count;

    public ConfigureRoomCountCommand(int count) {
        this.count = count;
    }

    @Override
    public void execute() {
        OfficeConfiguration.getInstance().configureRooms(count);
    }
}
