package Mid_term;
import java.util.ArrayList;

class Driver {
    private String ID;
    private String name;
    private String licenseType;

    public Driver(String ID, String name, String licenseType) {
        this.ID = ID;
        this.name = name;
        this.licenseType = licenseType;
    }

    public void displayDriverDetails() {
        System.out.println("Driver ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("License Type: " + licenseType);
    }
}

class Vehicle {
    static int count;
    private String vehicleID;
    private String vehicleType;
    private int regNo;
    private Driver driver;

    public Vehicle(String vehicleID, String vehicleType, int regNo, Driver driver) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.driver = driver;
        count++;
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Type: " + vehicleType);
        System.out.println("Registration No: " + regNo);
        driver.displayDriverDetails();
        System.out.println("-------------------");
    }
}

class Fleet {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    public void displayFleetDetails() {
        System.out.println("Fleet Details:");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
        }
        System.out.println("Total Vehicles in Fleet: " + vehicles.size());
    }
}

public class Logistics_COmpany {
    public static void main(String[] args) {
        // Create multiple drivers
        Driver d1 = new Driver("D101", "Ramesh", "Heavy");
        Driver d2 = new Driver("D102", "Suresh", "Light");
        Driver d3 = new Driver("D103", "Priya", "Medium");

        // Create vehicles and associate them with drivers
        Vehicle v1 = new Vehicle("V201", "Truck", 12345, d1);
        Vehicle v2 = new Vehicle("V202", "Van", 67890, d2);
        Vehicle v3 = new Vehicle("V203", "Car", 11223, d3);

        // Create fleet and add vehicles
        Fleet fleet = new Fleet();
        fleet.addVehicle(v1);
        fleet.addVehicle(v2);
        fleet.addVehicle(v3);

        // Display fleet details before removal
        System.out.println("=== Fleet Before Removal ===");
        fleet.displayFleetDetails();

        // Remove one vehicle
        fleet.removeVehicle(v2);

        // Display fleet details after removal
        System.out.println("=== Fleet After Removal ===");
        fleet.displayFleetDetails();
    }
}
