import java.util.*;

// Reservation
class ReservationUC8 {
    private int id;
    private String guestName;
    private String roomType;
    private String roomId;

    public ReservationUC8(int id, String guestName, String roomType, String roomId) {
        this.id = id;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public void display() {
        System.out.println("Booking confirmed for Guest: " + guestName + ", Room ID: " + roomId);
    }
}

// Booking History
class BookingHistoryUC8 {
    private List<ReservationUC8> history = new ArrayList<>();

    public void addBooking(ReservationUC8 r) {
        history.add(r);
    }

    public List<ReservationUC8> getBookings() {
        return history;
    }
}

// Report Service
class BookingReportServiceUC8 {

    public void showBookings(List<ReservationUC8> bookings) {
        for (ReservationUC8 r : bookings) {
            r.display();
        }
    }
}

// Main
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistoryUC8 history = new BookingHistoryUC8();
        BookingReportServiceUC8 report = new BookingReportServiceUC8();

        // Add bookings (same as your screenshot)
        history.addBooking(new ReservationUC8(1, "Abhi", "Single Room", "Single-1"));
        history.addBooking(new ReservationUC8(2, "Subha", "Single Room", "Single-2"));
        history.addBooking(new ReservationUC8(3, "Vanmathi", "Suite Room", "Suite-1"));

        // Display
        report.showBookings(history.getBookings());
    }
}