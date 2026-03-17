/**
 * Book My Stay App
 *
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates use of HashMap for managing room availability.
 *
 * @author Srutesh
 */

import java.util.HashMap;

// Inventory class (Single source of truth)
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor → initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Add room types with availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("===== Room Inventory =====");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " → Available: " + inventory.get(roomType));
        }

        System.out.println("==========================");
    }
}

// Main class (Public class)
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Example update
        System.out.println("\nUpdating Single Room availability...\n");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();
    }
}