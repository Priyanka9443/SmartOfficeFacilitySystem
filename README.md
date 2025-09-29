<<<<<<< HEAD
**Exercise1 Design Patterns**

## BEHAVIOURAL DESIGN PATTERN

### 1. Observer Pattern – Room Occupancy

**Use Case**
This console-based application monitors room occupancy. Sensors like **Lights** and **AC** automatically respond when room status changes (Occupied/Empty).

**Design Pattern**
**Observer Pattern** – Establishes a **one-to-many relationship** between a subject (Room) and observers (Sensors). When the subject's state changes, all observers are automatically notified.

**How it Relates to the Use Case**

* **Subject:** `Room` class that maintains occupancy status.
* **Observers:** `Light` and `AC` classes that implement `Observer` interface to react to occupancy changes.

**Classes**

* `Room` → Manages occupancy status and notifies observers.
* `Observer` → Interface for objects that react to status changes.
* `Light`  & `AC` → Concrete observers implementing `Observer`.
* `MainObserverDemo` → Main class to demonstrate the pattern.

**Sample Output**

```
Light ON - Room Occupied
AC ON - Room Occupied
Light OFF - Room Empty
AC OFF - Room Empty
```

---

### 2. Command Pattern – Room Control Commands

**Use Case**
Allows performing actions like **turning devices ON/OFF** or **booking/canceling rooms** using command objects. This separates the **request** from the **execution**, making it easy to extend operations.

**Design Pattern**
**Command Pattern** – Encapsulates a request as an object, allowing you to parameterize clients with different commands and queue or log them.

**How it Relates to the Use Case**

* **Invoker:** `Invoker` class executes commands.
* **Command Interface:** `Command` interface defines `execute()` method.
* **Concrete Commands:** `TurnOnLightCommand`, `TurnOffLightCommand`.
* **Receiver:** `Light` class that performs actual actions.

**Classes**

* `Command` → Interface with `execute()` method.
* `TurnOnLightCommand` / `TurnOffLightCommand` → Concrete command classes.
* `Invoker` → Executes commands.
* `Light` → Receiver class performing actual operations.
* `MainCommandDemo` → Main class demonstrating commands.

**Sample Output**

```
Light turned ON
Light turned OFF
```



## CREATIONAL DESIGN PATTERN

### 1. Singleton Pattern – Smart Home Hub

**Use Case**
Ensures that there is **only one instance of the Smart Home Hub** managing all devices in the system. This guarantees a single source of truth for device management.

**Design Pattern**
**Singleton Pattern** – Restricts a class to a single instance and provides a global point of access to it.

**How it Relates to the Use Case**

* **Singleton Class:** `SmartHomeHub` ensures that only one hub instance exists.
* **Global Access:** Other classes access the hub via a static `getInstance()` method.

**Classes**

* `SmartHomeHub` → Singleton class managing all devices, schedules, and triggers.
* `MainSingletonDemo` → Main class demonstrating singleton behavior.

**Sample Output**

```
Smart Home Hub is running
```

---

### 2. Factory Pattern – Device Creation

**Use Case**
Creates different types of devices (**Light, Thermostat, DoorLock**) dynamically based on user input. This avoids hardcoding and centralizes the creation logic.

**Design Pattern**
**Factory Pattern** – Provides an interface for creating objects but lets subclasses decide which class to instantiate.

**How it Relates to the Use Case**

* **Factory Class:** `DeviceFactory` creates device objects without exposing the creation logic to the client.
* **Client Code:** Requests devices by type, and the factory returns the correct device instance.

**Classes**

* `DeviceFactory` → Creates instances of devices based on input type.
* `Device` → Abstract class defining common behavior for devices.
* `Light`, `Thermostat`, `DoorLock` → Concrete device classes.
* `MainFactoryDemo` → Demonstrates device creation using the factory.

**Sample Output**

```
Light turned ON
Thermostat turned ON
DoorLock turned ON
```

---



## STRUCTURAL DESIGN PATTERN

### 1. Composite Pattern – Device Hierarchy

**Use Case**
Represents a hierarchy of devices (e.g., floors, rooms, individual devices) where **composite objects** (like a floor or room) and **leaf objects** (like Light, Thermostat, DoorLock) can be treated uniformly.

**Design Pattern**
**Composite Pattern** – Allows treating individual objects and compositions of objects uniformly, simplifying the management of part-whole hierarchies.

**How it Relates to the Use Case**

* **Composite:** `DeviceComposite` can contain other composites or individual devices.
* **Leaf:** `DeviceLeaf` (Light, Thermostat, DoorLock) represents individual devices.
* **Client Code:** Operates on the top-level composite without worrying whether it's a leaf or composite.

**Classes**

* `DeviceComponent` → Abstract class defining common operations.
* `DeviceComposite` → Composite class containing children devices or composites.
* `DeviceLeaf` → Leaf class representing individual devices.
* `MainCompositeDemo` → Demonstrates turning ON/OFF all devices through the hierarchy.

**Sample Output**

```
Device Hierarchy:
Composite Device: Floor 1
Device: Thermostat 1
Device: Door Lock 1

Turning ON all devices:
Turning ON composite: Floor 1
Turning ON composite: Room 1
Light 1 turned ON
Thermostat 1 turned ON
Door Lock 1 turned ON

Turning OFF all devices:
Turning OFF composite: Floor 1
Turning OFF composite: Room 1
Light 1 turned OFF
Thermostat 1 turned OFF
Door Lock 1 turned OFF
```

---

### 2. Proxy Pattern – Device Access Control

**Use Case**
Controls access to real devices and adds additional behavior such as **logging** without modifying the device classes themselves.

**Design Pattern**
**Proxy Pattern** – Provides a surrogate or placeholder to control access to another object.

**How it Relates to the Use Case**

* **Proxy Class:** `DeviceProxy` wraps around the real device to add logging or status reporting.
* **Real Device:** Actual `Device` implementation performs the real operation.
* **Client Code:** Interacts with the proxy, not the real device directly.

**Classes**

* `Device` → Real device class.
* `DeviceProxy` → Proxy class controlling access and adding logging.
* `MainProxyDemo` → Demonstrates controlling and monitoring device actions via proxy.

**Sample Output**

```
Logging: Turning on device
Light turned ON
```

---



**Exercise 2 – Smart Office Facility** 
---

## 🏢 Smart Office Facility – Exercise 2

### Use Case Overview

The **Smart Office System** is a console-based application designed to simulate an office environment with multiple meeting rooms. It allows users to **book rooms, cancel bookings, and add occupants**, while automatically controlling room devices like **💡lights and AC** based on occupancy.

The system ensures efficient management of office resources and automates routine operations using design patterns.

---

### Functionalities

* **Room Management:** Create and manage multiple meeting rooms.
* **Booking:** Book a room for a specified duration.
* **Cancellation:** Cancel room bookings.
* **Occupancy Management:** Add occupants to a room.
* **Device Automation:** Lights and AC are automatically controlled based on room occupancy.

---

### 🧩 Design Patterns Used

#### 1. **Singleton Pattern**

**Purpose:** Ensures a single global instance of the office configuration exists.
**Relation to Use Case:** Only one office configuration instance manages all rooms and bookings.
**Class Involved:**

* `OfficeConfiguration` → Singleton class holding office setup and rooms.

#### 2. **Observer Pattern**

**Purpose:** Keeps devices (lights, AC) updated when room occupancy changes.
**Relation to Use Case:** Devices automatically respond when a room becomes occupied or empty.
**Classes Involved:**

* `Room` → Subject that notifies observers about occupancy changes.
* `LightSystem`, `AirConditioningSystem` → Observers that respond to room status changes.
* `Observer` → Interface implemented by all devices.

#### 3. **Command Pattern**

**Purpose:** Encapsulates actions (booking, cancellation, updating status) as commands.
**Relation to Use Case:** Makes it easy to add new operations in the future.
**Classes Involved:**

* `Command` → Interface for all commands.
* `BookRoomCommand`, `CancelBookingCommand` → Concrete command implementations.
* `Invoker` → Executes commands based on user input.

---

### 🗂️ Classes and Their Responsibilities

* `App.java` → Entry point; provides user menu and interacts with office system.
* `Room.java` → Represents a meeting room and manages its observers.
* `OfficeConfiguration.java` → Singleton class that holds all rooms and configurations.
* `Observer.java` → Interface for devices observing room status.
* `LightSystem.java` → Observer that controls lights.
* `AirConditioningSystem.java` → Observer that controls AC.
* `Command.java` → Interface for commands.
* `BookRoomCommand.java` → Command to book a room.
* `CancelBookingCommand.java` → Command to cancel a booking.
* `Invoker.java` → Executes commands.

---

### 🛠️ Compiling and Executing

**Compile all Java files recursively into the `out` folder:**

```powershell
cd Exercise2
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

**Run the application:**

```powershell
java -cp out App
```

**Sample Output:**

```
Enter number of meeting rooms:
3
Office configured with 3 meeting rooms: Room 1, Room 2, Room 3, 

Menu:
1. Book Room
2. Cancel Booking
3. Add Occupants
4. Exit
1
Enter Room ID, Start Time (HH:MM), Duration (mins):
1 4:00 40
Room 1 booked from 4:00 for 40 minutes.

Menu:
1. Book Room
2. Cancel Booking
3. Add Occupants
4. Exit
3
Enter Room ID and number of occupants:
1 4
Lights turned ON for Room 1
AC turned ON for Room 1
```

---

### 🛠️ Tech Stack

* **Programming Language:** Java – Object-Oriented principles for design pattern implementation.
* **JDK Version:** 17 – Stable and feature-rich environment.
* **Build and Execution:**

  * `javac` – Java compiler to compile source files.
  * `java` – Java runtime to execute bytecode.
* 

---

📞 Contact Information
    Gmail: sumathipriyanka2001@gmail.com
    Github:Priyanka9443

=======
# SmartOfficeFacilitySystem
This project is about Smart Office Facility 
>>>>>>> 34e0f16d730526c9198d554460f7835da5fde296
