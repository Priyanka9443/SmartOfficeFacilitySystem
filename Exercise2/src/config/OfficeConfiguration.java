// src/config/OfficeConfiguration.java
package config;

import models.Room;
import observers.AirConditioningSystem;
import observers.LightSystem;

import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, Room> rooms = new HashMap<>();

    private OfficeConfiguration() {}

    public static OfficeConfiguration getInstance() {
        if (instance == null) instance = new OfficeConfiguration();
        return instance;
    }

    public void configureRooms(int count) {
        for (int i = 1; i <= count; i++) {
            Room room = new Room(i);
            room.addObserver(new LightSystem());
            room.addObserver(new AirConditioningSystem());
            rooms.put(i, room);
        }
        System.out.print("Office configured with " + count + " meeting rooms: ");
        rooms.keySet().forEach(r -> System.out.print("Room " + r + ", "));
        System.out.println();
    }

    public void setRoomCapacity(int roomId, int capacity) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.setMaxCapacity(capacity);
            System.out.println("Room " + roomId + " maximum capacity set to " + capacity + ".");
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    public Room getRoom(int roomId) {
        return rooms.get(roomId);
    }

    public Map<Integer, Room> getRooms() { return rooms; }
}
