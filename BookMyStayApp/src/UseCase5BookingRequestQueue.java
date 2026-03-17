import java.util.*;

// Reservation class (Booking Request)
class ReservationUC5 {
    private int requestId;
    private String guestName;
    private String roomType;

    public ReservationUC5(int requestId, String guestName, String roomType) {
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

    public void display() {
        System.out.println("Request ID: " + requestId +
                " | Guest: " + guestName +
                " | Room: " + roomType);
    }
}

// Booking Queue (FIFO)
class BookingQueueUC5 {
    private Queue<ReservationUC5> queue;

    public BookingQueueUC5() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(ReservationUC5 reservation) {
        queue.add(reservation);
        System.out.println("Added to queue:");
        reservation.display();
    }

    // View all requests
    public void showQueue() {
        System.out.println("\n=== Booking Queue (FIFO Order) ===");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (ReservationUC5 r : queue) {
            r.display();
        }
    }
}

// Main class
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        BookingQueueUC5 bookingQueue = new BookingQueueUC5();

        // Simulating incoming requests
        bookingQueue.addRequest(new ReservationUC5(1, "Rahul", "Single Room"));
        bookingQueue.addRequest(new ReservationUC5(2, "Anita", "Double Room"));
        bookingQueue.addRequest(new ReservationUC5(3, "Kiran", "Suite Room"));

        // Display queue
        bookingQueue.showQueue();
    }
}