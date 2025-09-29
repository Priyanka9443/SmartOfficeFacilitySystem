// src/services/RoomBookingService.java
package services;

import models.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomBookingService {
    private static RoomBookingService instance;
    private Map<Room, String> bookings = new HashMap<>();

    private RoomBookingService() {}

    public static RoomBookingService getInstance() {
        if (instance == null) instance = new RoomBookingService();
        return instance;
    }

    public void bookRoom(Room room, String startTime, int duration) {
        if (room == null) {
            System.out.println("Invalid room.");
            return;
        }
        if (bookings.containsKey(room)) {
            System.out.println("Room " + room.getId() + " is already booked during this time. Cannot book.");
        } else {
            bookings.put(room, startTime);
            room.setBooked(true);
            System.out.println("Room " + room.getId() + " booked from " + startTime + " for " + duration + " minutes.");
        }
    }

    public void cancelBooking(Room room) {
        if (room == null || !bookings.containsKey(room)) {
            System.out.println("Booking not found. Cannot cancel.");
        } else {
            bookings.remove(room);
            room.setBooked(false);
            System.out.println("Booking for Room " + room.getId() + " cancelled successfully.");
        }
    }
}
