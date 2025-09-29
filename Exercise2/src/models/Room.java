package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import observers.Observer;

public class Room {
    private int id;
    private int occupants;
    private boolean booked;
    private LocalDateTime lastOccupiedTime;
    private int maxCapacity;
    private List<Observer> observers = new ArrayList<>();

    public Room(int id) {
        this.id = id;
        this.occupants = 0;
        this.booked = false;
    }

    public int getId() {
        return id;
    }

    public int getOccupants() {
        return occupants;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void addOccupants(int count) {
        this.occupants = count;
        if (count > 0) {
            this.lastOccupiedTime = LocalDateTime.now();
        }
        notifyObservers();
    }

    public LocalDateTime getLastOccupiedTime() {
        return lastOccupiedTime;
    }

    public void releaseBooking() {
        this.booked = false;
        this.occupants = 0;
        notifyObservers();
        System.out.println("Room " + id + " booking released. Lights and AC turned off.");
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
