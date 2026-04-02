import java.util.*;

// Add-On Service Class
class AddOnServiceUC7 {
    private String serviceName;
    private double price;

    public AddOnServiceUC7(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void display() {
        System.out.println(serviceName + " - ₹" + price);
    }
}

// Service Manager
class AddOnServiceManagerUC7 {

    // reservationId -> list of services
    private HashMap<Integer, List<AddOnServiceUC7>> serviceMap = new HashMap<>();

    // Add service to reservation
    public void addService(int reservationId, AddOnServiceUC7 service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added service to Reservation " + reservationId + ": " + service.getServiceName());
    }

    // Display services for a reservation
    public void showServices(int reservationId) {

        System.out.println("\nServices for Reservation " + reservationId + ":");

        List<AddOnServiceUC7> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        double total = 0;

        for (AddOnServiceUC7 s : services) {
            s.display();
            total += s.getPrice();
        }

        System.out.println("Total Add-On Cost: ₹" + total);
    }
}

// Main Class
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManagerUC7 manager = new AddOnServiceManagerUC7();

        // Sample services
        AddOnServiceUC7 wifi = new AddOnServiceUC7("WiFi", 200);
        AddOnServiceUC7 breakfast = new AddOnServiceUC7("Breakfast", 300);
        AddOnServiceUC7 pickup = new AddOnServiceUC7("Airport Pickup", 500);

        // Add services to reservations
        manager.addService(101, wifi);
        manager.addService(101, breakfast);

        manager.addService(102, pickup);

        // Display
        manager.showServices(101);
        manager.showServices(102);
    }
}