import java.util.*;

// Booking Request
class BookingRequest {
    String guestName;
    String roomType;

    public BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Shared Booking System
class BookingSystem {

    private Map<String, Integer> inventory = new HashMap<>();

    public BookingSystem() {
        inventory.put("Single", 2);
    }

    // Thread-safe booking
    public synchronized void bookRoom(BookingRequest request) {

        int available = inventory.getOrDefault(request.roomType, 0);

        if (available > 0) {
            inventory.put(request.roomType, available - 1);
            System.out.println("Booking successful for " + request.guestName);
        } else {
            System.out.println("Booking failed for " + request.guestName);
        }
    }
}

// Thread Class
class BookingThread extends Thread {

    BookingSystem system;
    BookingRequest request;

    public BookingThread(BookingSystem system, BookingRequest request) {
        this.system = system;
        this.request = request;
    }

    public void run() {
        system.bookRoom(request);
    }
}

// Main Class
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        BookingSystem system = new BookingSystem();

        // Requests
        BookingRequest r1 = new BookingRequest("Alice", "Single");
        BookingRequest r2 = new BookingRequest("Bob", "Single");
        BookingRequest r3 = new BookingRequest("Charlie", "Single");

        // Threads
        Thread t1 = new BookingThread(system, r1);
        Thread t2 = new BookingThread(system, r2);
        Thread t3 = new BookingThread(system, r3);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
