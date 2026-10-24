/**
 * Demonstrates the Vehicle class, getters/setters, selection and looping.
 */
public class Assignment1Main {
    public static void main(String[] args) {
        // The parameterized constructor initializes the first vehicle.
        Vehicle first = new Vehicle(
            "JQX1234", "Toyota", "Vios", 2023, 120.0, true, 18000.0
        );

        // The default constructor and setters initialize the second vehicle.
        Vehicle second = new Vehicle();
        second.setRegistrationNumber("JRX5678");
        second.setBrand("Honda");
        second.setModel("City");
        second.setYear(2022);
        second.setDailyRate(110.0);
        second.setAvailable(true);
        second.setMileageKm(24500.0);

        Vehicle[] fleet = { first, second };
        System.out.println("=== Fleet Summary ===");

        // A for-each loop visits every vehicle in the array.
        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel()
                + " | " + vehicle.getAvailabilityStatus());

            // The if statement selects an action based on availability.
            if (vehicle.isAvailable()) {
                System.out.printf("3-day estimate: RM%.2f%n",
                    vehicle.calculateRentalCost(3));
            } else {
                System.out.println("This vehicle cannot be rented now.");
            }
        }

        // A switch statement demonstrates selection based on the brand.
        switch (first.getBrand().toLowerCase()) {
            case "toyota":
                System.out.println("Toyota vehicle record selected.");
                break;
            case "honda":
                System.out.println("Honda vehicle record selected.");
                break;
            default:
                System.out.println("Other vehicle brand selected.");
        }

        // Demonstrate an operation and controlled attribute modification.
        first.addMileage(25.0);
        first.setAvailable(false);
        System.out.println("Updated mileage: " + first.getMileageKm() + " km");
        System.out.println("Updated status: " + first.getAvailabilityStatus());
    }
}