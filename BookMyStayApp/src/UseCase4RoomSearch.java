import java.util.*;

// Abstract Room
abstract class RoomUC4 {
    protected String type;
    protected int beds;
    protected double price;
    protected int sizeSqft;

    public RoomUC4(String type, int beds, double price, int sizeSqft) {
        this.type = type;
        this.beds = beds;
        this.price = price;
        this.sizeSqft = sizeSqft;
    }

    public abstract void displayDetails();
}

// Single Room
class SingleRoomUC4 extends RoomUC4 {
    public SingleRoomUC4() {
        super("Single Room", 1, 1000, 200);
    }

    public void displayDetails() {
        System.out.println(type + " | Beds: " + beds +
                " | Size: " + sizeSqft + " sqft | Price: ₹" + price);
    }
}

// Double Room
class DoubleRoomUC4 extends RoomUC4 {
    public DoubleRoomUC4() {
        super("Double Room", 2, 2000, 350);
    }

    public void displayDetails() {
        System.out.println(type + " | Beds: " + beds +
                " | Size: " + sizeSqft + " sqft | Price: ₹" + price);
    }
}

// Suite Room
class SuiteRoomUC4 extends RoomUC4 {
    public SuiteRoomUC4() {
        super("Suite Room", 3, 5000, 600);
    }

    public void displayDetails() {
        System.out.println(type + " | Beds: " + beds +
                " | Size: " + sizeSqft + " sqft | Price: ₹" + price);
    }
}

// Inventory
class RoomInventoryUC4 {
    private HashMap<String, Integer> inventory;

    public RoomInventoryUC4() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// Search Service
class RoomSearchService {

    public void searchAvailableRooms(RoomInventoryUC4 inventory, List<RoomUC4> rooms) {

        System.out.println("===== Available Rooms =====");

        for (RoomUC4 room : rooms) {
            int available = inventory.getAvailability(room.type);

            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
            }
        }

        System.out.println("===========================");
    }
}

// Main class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventoryUC4 inventory = new RoomInventoryUC4();

        List<RoomUC4> rooms = new ArrayList<>();
        rooms.add(new SingleRoomUC4());
        rooms.add(new DoubleRoomUC4());
        rooms.add(new SuiteRoomUC4());

        RoomSearchService search = new RoomSearchService();
        search.searchAvailableRooms(inventory, rooms);
    }
}