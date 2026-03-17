import java.util.*;

// Reservation Class
class ReservationUC6 {
    private int requestId;
    private String guestName;
    private String roomType;

    public ReservationUC6(int requestId, String guestName, String roomType) {
        this.requestId = requestId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Booking Queue (FIFO)
class BookingQueueUC6 {
    private Queue<ReservationUC6> queue = new LinkedList<>();

    public void addRequest(ReservationUC6 r) {
        queue.add(r);
    }

    public ReservationUC6 getNextRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Inventory
class RoomInventoryUC6 {
    private HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventoryUC6() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceAvailability(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Allocation Service
class RoomAllocationServiceUC6 {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private HashMap<String, Set<String>> allocationMap = new HashMap<>();

    // Correct Room ID format
    private String generateRoomId(String roomType, int counter) {
        return roomType.replace(" ", "").toUpperCase() + "_" + counter;
    }

    public void processBookings(BookingQueueUC6 queue, RoomInventoryUC6 inventory) {

        System.out.println("=== Room Allocation Processing ===");

        int counter = 1;

        while (!queue.isEmpty()) {

            ReservationUC6 req = queue.getNextRequest();
            String type = req.getRoomType();

            if (inventory.getAvailability(type) > 0) {

                String roomId;

                // Ensure unique ID
                do {
                    roomId = generateRoomId(type, counter++);
                } while (allocatedRoomIds.contains(roomId));

                allocatedRoomIds.add(roomId);

                allocationMap.putIfAbsent(type, new HashSet<>());
                allocationMap.get(type).add(roomId);

                inventory.reduceAvailability(type);

                System.out.println("\nBooking CONFIRMED for " + req.getGuestName());
                System.out.println("Room Allocated: " + roomId);

            } else {
                System.out.println("\nBooking FAILED for " + req.getGuestName() + " (No availability)");
            }
        }
    }
}

// Main Class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        BookingQueueUC6 queue = new BookingQueueUC6();
        RoomInventoryUC6 inventory = new RoomInventoryUC6();
        RoomAllocationServiceUC6 service = new RoomAllocationServiceUC6();

        // Sample Requests
        queue.addRequest(new ReservationUC6(1, "Abhi", "Single Room"));
        queue.addRequest(new ReservationUC6(2, "Subha", "Single Room"));
        queue.addRequest(new ReservationUC6(3, "Vanmathi", "Suite Room"));

        // Process
        service.processBookings(queue, inventory);
    }
}