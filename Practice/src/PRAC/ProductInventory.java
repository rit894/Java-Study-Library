package PRAC;
class Product{
	

private String productId;
private String productName;
private double  price;
private int Quantity;


public Product() {
	
	productId="Unknown";
	productName = "Unknown";
	price = 0.0;
	Quantity = 0;
	
	
}
 
public Product(String p,String pn,double pr,int q) {
	
	productId=p;
	productName = pn;
	price = pr;
	Quantity = q ; 
	
}

public void addStock(int qty) {
	Quantity +=qty;
	
}

public void sellProduct(int qty) {
	
	if (Quantity>0) {
		Quantity-=qty;
	}
	else {
		System.out.println("The quantity of this product is loww please try again later");
		
	}
}
public void displayProductDetails() {
	System.out.println(productId);
	System.out.println(productName);
	System.out.println(price);
	System.out.println(Quantity);
	
	
	
}


}


public class ProductInventory {

	public static void main(String[] args) {
		Product p1 = new Product();
		p1.displayProductDetails();
		Product p2 = new Product("321546","milk",23.56,5);
		
		p2.displayProductDetails();
		p2.addStock(15);
		p2.displayProductDetails();
		p2.sellProduct(6);
		p2.displayProductDetails();

	}

	
}
