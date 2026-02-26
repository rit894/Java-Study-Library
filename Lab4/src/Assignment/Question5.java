package Assignment;
class Car {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}


public class Question5 {
    public static void parkCar(Car[] lot, Car newCar) {
        for (int i = 0; i < lot.length; i++) {
            if (lot[i] == null) { 
                lot[i] = newCar;
                System.out.println("Car " + newCar.getBrand() +
                                   " parked successfully at slot " + i + ".");
                printLotStatus(lot);
                
            }
        }
        System.out.println("Parking Lot Full");
    }

    public static void printLotStatus(Car[] lot) {
        System.out.print("Current Lot Status: [");
        for (int i = 0; i < lot.length; i++) {
            if (lot[i] != null) {
                System.out.print(lot[i].getBrand());
            } else {
                System.out.print("null");
            }
            if (i < lot.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Car[] lot = new Car[4];
        lot[0] = new Car("Toyota");
        lot[1] = new Car("Honda");
        lot[2] = null;
        lot[3] = null;

        System.out.println("Initial Lot:");
        printLotStatus(lot);

        Car newArrival = new Car("Ford");
        parkCar(lot, newArrival);
    }
}

