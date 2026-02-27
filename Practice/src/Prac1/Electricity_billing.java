package Prac1;
import java.util.Scanner;

class BillingAccount{
	private String name;
	private int accNO;
	private int units;
	private boolean islate;
	
	
	
	public BillingAccount(String n,int accNo, int u) {
		name = n;
		this.accNO = accNo;
		units = u;
	}
	public void units_consumed() {
		Scanner obj = new Scanner(System.in);
		System.out.print("How many units did you consume this month: ");
		int consumption = obj.nextInt();
		obj.nextLine();
		units = consumption;
		System.out.println("Are you paying your bills late(y/n): ");
		String ans = obj.nextLine();
		if(ans.equalsIgnoreCase("y")) {
			islate=true;
		}else {
			islate=false;
		}
		
		
	}	
	public void Calculate_bill() {
	    double cost = 0.0;

	    if (units < 0) {
	        System.out.println("Invalid number of units. Please try again.");
	        return;
	    }
	    if (units < 100) {
	        cost = 10.0 + (units * 0.50);
	    } else if (units >= 100 && units <= 300) {
	        int diff = units - 100;
	        cost = 10.0 + (100 * 0.50) + (diff * 0.75);
	    } else if (units > 300) {
	        int diff = units - 300;
	        cost = 10.0 + (100 * 0.50) + (200 * 0.75) + (diff * 1.20);
	    }


	    if (islate) {
	        cost += cost * 0.05; // 5% late fee
	    }

	    System.out.println("Cost : " + cost);
	}

	
	
}
public class Electricity_billing {

	public static void main(String[] args) {
		BillingAccount a = new BillingAccount("simpson",123456, 0);
		a.units_consumed();
		a.Calculate_bill();
		

	}

}
