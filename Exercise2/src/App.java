import config.OfficeConfiguration;
import models.Room;
import commands.*;
import services.CommandInvoker;
import observers.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OfficeConfiguration office = OfficeConfiguration.getInstance();

        // Configure rooms
        System.out.println("Enter number of meeting rooms:");
        int roomCount = sc.nextInt();
        office.configureRooms(roomCount);

        // Attach observers
        for (int i = 1; i <= roomCount; i++) {
            Room room = office.getRoom(i);
            room.addObserver(new LightSystem());
            room.addObserver(new AirConditioningSystem());
        }

        // Main loop
        while (true) {
            System.out.println("\nMenu:\n1. Book Room\n2. Cancel Booking\n3. Add Occupants\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Room ID, Start Time (HH:MM), Duration (mins):");
                    int id = sc.nextInt();
                    String start = sc.next();
                    int duration = sc.nextInt();
                    Room room = office.getRoom(id);
                    if (room != null)
                        CommandInvoker.execute(new BookRoomCommand(room, start, duration));
                    else
                        System.out.println("Invalid Room ID");
                    break;

                case 2:
                    System.out.println("Enter Room ID to cancel booking:");
                    id = sc.nextInt();
                    room = office.getRoom(id);
                    if (room != null)
                        CommandInvoker.execute(new CancelRoomCommand(room));
                    else
                        System.out.println("Invalid Room ID");
                    break;

                case 3:
                    System.out.println("Enter Room ID and number of occupants:");
                    id = sc.nextInt();
                    int count = sc.nextInt();
                    room = office.getRoom(id);
                    if (room != null)
                        CommandInvoker.execute(new AddOccupantCommand(room, count));
                    else
                        System.out.println("Invalid Room ID");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
