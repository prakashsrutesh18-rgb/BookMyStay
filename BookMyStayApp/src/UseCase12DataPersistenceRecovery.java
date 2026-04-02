import java.io.*;
import java.util.*;

// Inventory class (Serializable)
class Inventory implements Serializable {
    Map<String, Integer> rooms;

    public Inventory() {
        rooms = new HashMap<>();
    }
}

public class UseCase12DataPersistenceRecovery {

    static final String FILE_NAME = "inventory.dat";

    public static void main(String[] args) {

        System.out.println("System Recovery");

        Inventory inventory = loadData();

        if (inventory == null || inventory.rooms.isEmpty()) {
            System.out.println("No valid inventory data found.");
        } else {
            System.out.println("Inventory restored successfully:");
            for (String type : inventory.rooms.keySet()) {
                System.out.println(type + " : " + inventory.rooms.get(type));
            }
        }
    }

    // Load (Deserialization)
    public static Inventory loadData() {
        try {
            File file = new File(FILE_NAME);

            // If file does not exist
            if (!file.exists()) {
                return null;
            }

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(FILE_NAME));

            Inventory inv = (Inventory) ois.readObject();
            ois.close();

            return inv;

        } catch (Exception e) {
            // Handles corrupted file also
            return null;
        }
    }
}
