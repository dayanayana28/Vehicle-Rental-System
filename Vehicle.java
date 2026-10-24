/**
 * Vehicle models one vehicle in a simple vehicle-rental system.
 * All attributes are private so that values can be checked through setters.
 */
public class Vehicle {
    private String registrationNumber; // Unique vehicle registration identifier.
    private String brand;              // Manufacturer, for example Toyota.
    private String model;              // Model name, for example Vios.
    private int year;                  // Year the vehicle was manufactured.
    private double dailyRate;          // Rental charge per day in RM.
    private boolean available;          // True when the vehicle can be rented.
    private double mileageKm;           // Current mileage in kilometres.

    /**
     * Default constructor: creates a valid placeholder vehicle.
     */
    public Vehicle() {
        this("UNASSIGNED", "Unknown", "Unknown", 2020, 0.0, true, 0.0);
    }

    /**
     * Parameterized constructor: initializes all seven attributes.
     */
    public Vehicle(String registrationNumber, String brand, String model,
                   int year, double dailyRate, boolean available, double mileageKm) {
        setRegistrationNumber(registrationNumber);
        setBrand(brand);
        setModel(model);
        setYear(year);
        setDailyRate(dailyRate);
        setAvailable(available);
        setMileageKm(mileageKm);
    }

    // Getters provide controlled read access to private attributes.
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getMileageKm() {
        return mileageKm;
    }

    // Setters validate values before changing the object's state.
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
        this.registrationNumber = registrationNumber.trim();
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand.trim();
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model.trim();
    }

    public void setYear(int year) {
        if (year < 1886 || year > 2100) {
            throw new IllegalArgumentException("Year must be between 1886 and 2100.");
        }
        this.year = year;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative.");
        }
        this.dailyRate = dailyRate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setMileageKm(double mileageKm) {
        if (mileageKm < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative.");
        }
        this.mileageKm = mileageKm;
    }

    /**
     * Calculates a basic rental estimate. A valid rental must be at least one day.
     */
    public double calculateRentalCost(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Rental days must be at least 1.");
        }
        return dailyRate * days;
    }

    /**
     * Adds distance travelled while preventing a negative mileage update.
     */
    public void addMileage(double kilometres) {
        if (kilometres < 0) {
            throw new IllegalArgumentException("Added mileage cannot be negative.");
        }
        setMileageKm(mileageKm + kilometres);
    }
}
/** Returns a readable status without exposing the field directly. */
public String getAvailabilityStatus() {
    return available ? "Available" : "Rented";
}
}