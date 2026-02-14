package PRAC;
import java.util.ArrayList;
import java.util.Scanner;
class bankAccount{
	 private String accountNumber;
	    private String accountHolder;
	    private double balance;

	    
	    public bankAccount() {
	        accountNumber = "default";
	        accountHolder = "Physic";
	        balance = 0.0;
	    }

	    
	    public bankAccount(String a, String b, double c) {
	        accountNumber = a;
	        accountHolder = b;
	        balance = c;
	    }

	    
	    public void deposit(double a) {
	        if (a > 0) {
	            balance += a;   // FIXED
	            System.out.println("Deposited: " + a);
	        } else {
	            System.out.println("Invalid deposit amount");
	        }
	    }

	  
	    public void withdraw(double a) {
	        if (a <= 0) {
	            System.out.println("Invalid withdrawal amount");
	        } else if (a > balance) {
	            System.out.println("Insufficient balance");
	        } else {
	            balance -= a;
	            System.out.println("Withdrawn: " + a);
	        }
	    }
	    public String getAccountNumber() {
	    	return accountNumber;
	    }


	   
	    public void displayAccountDetails() {
	        System.out.println("\n--- Account Details ---");
	        System.out.println("Account Number : " + accountNumber);
	        System.out.println("Account Holder : " + accountHolder);
	        System.out.println("Balance        : " + balance);
	        System.out.println("------------------------");
	    }
}

public class Bank {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList<bankAccount> bankaccountList = new ArrayList<>();

        System.out.print("How many accounts would you like to create? ");
        int n = obj.nextInt();
        obj.nextLine();

        int i = 0;

        while (i < n) {

            System.out.println("Enter account Number: ");
            String accnum = obj.nextLine();

            System.out.println("Enter account holder name: ");
            String acchold = obj.nextLine();

            System.out.println("Enter balance in your account: ");
            double bala = obj.nextDouble();
            obj.nextLine();

            bankAccount b1 = new bankAccount(accnum, acchold, bala);
            bankaccountList.add(b1);

            i++;

            // When we reach the last account
            if (i == n) {
                System.out.print("Would you like to create more accounts? (yes/no): ");
                String choice = obj.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("How many more accounts? ");
                    int more = obj.nextInt();
                    obj.nextLine();

                    n += more; // increase total accounts
                }
            }
        }

        System.out.println("All accounts created successfully!");
    
        System.out.println("Enter account Number to search : ");
		String acno =obj. nextLine();
		boolean found = false;
		for (bankAccount j: bankaccountList) {
			
			String Acc = j.getAccountNumber();
			if (acno.equals(Acc)) {
				System.out.println("Here is the bank account details you are searchingfor ...");
				j.displayAccountDetails();
				break;
			}
			if (!found) { System.out.println("Account has not been found. Please check the given credentials."); }
			}
			
			
			
			
		}
        
        
        
        
        
        
    }


	
		
		
		
		
		
		
	


