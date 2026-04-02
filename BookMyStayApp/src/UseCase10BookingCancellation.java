import java.util.*;

// Custom Exception
class CancellationException extends Exception {
    public CancellationException(String message) {
        super(message);
    }
}

public class UseCase10BookingCancellation {

    // Inventory
    static Map<String, Integer> inventory = new HashMap<>();

    // Stack for rollback (LIFO)
    static Stack<String> rollbackStack = new Stack<>();

    public static void main(String[] args) {

        // Initialize inventory (as per expected output)
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        try {
            System.out.println("Booking Cancellation");

            // Simulated booking to cancel
            String roomType = "Single";
            String roomId = "Single-1";

            // Validate cancellation
            if (!inventory.containsKey(roomType)) {
                throw new CancellationException("Invalid room type.");
            }

            // --- Rollback Process ---
            rollbackStack.push(roomId); // push into stack

            // Restore inventory
            inventory.put(roomType, inventory.get(roomType) + 1);

            // Output (MATCH EXACT FORMAT)
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

            System.out.println("\nRollback History (Most Recent First):");
            System.out.println("Released Reservation ID: " + rollbackStack.peek());

            System.out.println("\nUpdated " + roomType + " Room Availability: " + inventory.get(roomType));

        } catch (CancellationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}