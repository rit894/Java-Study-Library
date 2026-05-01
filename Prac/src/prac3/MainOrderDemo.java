package prac3;
import java.io.*;

// 1. Abstract Base Class
abstract class Order {
    final double MIN_ORDER_VALUE = 100.0;

    protected int id;
    protected String name;
    protected double totalAmount;
    protected boolean isPaid;

    public Order(int id, String name, double ta) throws Exception {
        if (ta < MIN_ORDER_VALUE) {
            throw new Exception("Order value below minimum allowed: " + MIN_ORDER_VALUE);
        }
        this.id = id;
        this.name = name;
        this.totalAmount = ta;
        this.isPaid = false;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + name);
        System.out.println("Order Value: " + totalAmount);
        System.out.println("Paid: " + isPaid);
    }

    // Abstract method
    public abstract double calculateFinalAmount() throws Exception;

    // Final method
    public final void generateInvoice() throws Exception {
        System.out.println("=== INVOICE ===");
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + name);
        System.out.println("Order Value: " + totalAmount);
        System.out.println("Final Amount: " + calculateFinalAmount());
        System.out.println("Payment Status: " + (isPaid ? "Paid" : "Pending"));
    }
}

// 2. Interface


// 3. Derived Class
class ExpressOrder extends Order implements PaymentService {
    private int deliveryCharge;
    private int deliveryTime;

    public ExpressOrder(int id, String name, double ta, int dc, int dt) throws Exception {
        super(id, name, ta); // super keyword
        this.deliveryCharge = dc;
        this.deliveryTime = dt;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Charge: " + deliveryCharge);
        System.out.println("Delivery Time: " + deliveryTime + " mins");
    }

    @Override
    public double calculateFinalAmount() throws Exception {
        double finalAmount = totalAmount + deliveryCharge;
        if (finalAmount <= MIN_ORDER_VALUE) {
            throw new Exception("Final amount must be above " + MIN_ORDER_VALUE);
        }
        return finalAmount;
    }

    @Override
    public void processPayment(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid payment amount.");
        }
        if (amount < calculateFinalAmount()) {
            throw new Exception("Insufficient payment.");
        }
        isPaid = true;
        System.out.println("Payment processed: " + amount);
        logTransaction("Payment", amount);
    }

    @Override
    public void refundPayment(double amount) throws Exception {
        if (!isPaid) {
            throw new Exception("Refund not possible. Order not paid.");
        }
        if (amount <= 0) {
            throw new Exception("Invalid refund amount.");
        }
        isPaid = false;
        System.out.println("Refund processed: " + amount);
        logTransaction("Refund", amount);
    }

    // File Handling
    private void logTransaction(String type, double amount) {
        try (FileWriter fw = new FileWriter("orders.txt", true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println("Order ID: " + id +
                        " | Customer: " + name +
                        " | Transaction: " + type +
                        " | Amount: " + amount +
                        " | Final Amount: " + (totalAmount + deliveryCharge) +
                        " | Paid: " + isPaid);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            System.out.println("=== STORED ORDER RECORDS ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}

// 9. Main Class
public class MainOrderDemo {
    public static void main(String[] args) {
        try {
            ExpressOrder order = new ExpressOrder(101, "Sridhar", 50, 50, 30);

            order.displayOrderDetails();
            order.processPayment(550);
            order.generateInvoice();
            order.refundPayment(550);

            ExpressOrder.readFromFile();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
