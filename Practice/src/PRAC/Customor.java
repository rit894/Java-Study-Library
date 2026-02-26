package PRAC;
import java.util.ArrayList;
import java.util.Scanner;


public class Producst {
    private String name;
    private double price;
    private int id;

    public Producst(String n, double p, int i) {
        name = n;
        price = p;
        id = i;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Price: " + price + ", ID: " + id;
    }
}

class ShoppingCart {
    public ArrayList<Producst> products;
    public ArrayList<Producst> cart;

    public ShoppingCart() {
        products = new ArrayList<>();
        cart = new ArrayList<>();

        // Add some sample products
        products.add(new Producst("milk", 12.3, 45));
        products.add(new Producst("mfew", 15.3, 4));
        products.add(new Producst("milk", 1.3, 5));
    }

    public void showMenu() {
        System.out.println("Available products:");
        for (Producst prod : products) {
            System.out.println(prod);
        }
    }

    public void addItem() {
        Scanner obj = new Scanner(System.in);

        showMenu();
        System.out.println("How many items would you like to buy?");
        int ch = obj.nextInt();
        obj.nextLine(); // consume newline

        int j = 0;
        while (j < ch) {
            System.out.println("PLEASE ENTER THE PRODUCT NAME:");
            String name = obj.nextLine();

            boolean found = false;
            for (Producst prod : products) {
                if (prod.getName().equalsIgnoreCase(name)) {
                    cart.add(prod);
                    System.out.println(name + " added to cart.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Product Not Found.");
            }
            j++;
        }

        System.out.println("Your Cart Contains:");
        for (Producst prod : cart) {
            System.out.println(prod);
        }

        // Calculate total bill
        double total = 0;
        for (Producst prod : cart) {
            total += prod.getPrice();
        }
        System.out.println("Total Bill: " + total);
    }
}

public class Customor {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem();
    }
}
