import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Validator Class
class InvalidBookingValidator {

    // Valid room types (CASE-SENSITIVE)
    private static final List<String> validRoomTypes =
            Arrays.asList("Single", "Double", "Suite");

    public static void validateRoomType(String roomType)
            throws InvalidBookingException {

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Booking failed: Invalid room type selected.");
        }
    }
}

// Main Class
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Booking Validation");

            // Input
            System.out.print("Enter guest name: ");
            String name = sc.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = sc.nextLine();

            // Validation (Fail-Fast)
            InvalidBookingValidator.validateRoomType(roomType);

            // If valid
            System.out.println("Booking Successful for " + name);

        } catch (InvalidBookingException e) {
            // Exact required output
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
