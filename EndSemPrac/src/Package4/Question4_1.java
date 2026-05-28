package Package4;
import java.util.*;
import java.io.*;


 abstract class Account{
	
	protected String AccNum;
	protected String AccName;
	protected double Balance;
	public Account(String accNum, String accName, double balance) {
		
		AccNum = accNum;
		AccName = accName;
		Balance = balance;
	}
	
	public void DisplayAccDetails() {
		
		System.out.println("Account NUmber : "+AccNum);

		System.out.println("Account Holder Name : "+AccName);

		System.out.println("BAlance : "+Balance);
		
		
	}
	
	abstract double CalculateIntrest();
	
	
	
}

class PA extends Account implements TransactionService{
	
	final int  MIN_BALANCE = 1000;
	
	protected int WithdrawalLimit=1000;

	public PA(String accNum, String accName, double balance) {
		super(accNum, accName, balance);
		
	}
	
	public void DisplayAccDetails() {
		super.DisplayAccDetails();
		System.out.println("Withdrwal Lmit : "+WithdrawalLimit);
	}

	@Override
	double CalculateIntrest() {
		
		double Intrest = 0.3*Balance;
		
		return Intrest;
		
		
		
	}

	@Override
	public void deposit(double a) {
		
		Balance += a;
		
		System.out.println("Current Balance : "+Balance+" after Adding "+a);
		
		
		
		
	}

	
	@Override
	public void withdrawal(double a) throws Exception {
	    if (Balance-a <= MIN_BALANCE) {
	        throw new Exception("Failed Error: Current Balance < MINIMUM_BALANCE");
	    } else {
	        Balance -= a;
	    }
	}

	
	public final void generateSTATEMENT() {
		
		this.DisplayAccDetails();
		System.out.println("MINIMUM BALNCE : "+MIN_BALANCE);
		
		
	}
	
	public void saveUp() {
		try(FileWriter fw = new FileWriter("Accounts.txt",true);
				PrintWriter pw = new PrintWriter(fw)){
			
			pw.println("AccountID : "+AccNum+" |  Account Holder Name : "+AccName+" | Balance : "+Balance);
			System.out.println("Saved to OS SUccesfully ");
			
				
		}
		catch(Exception e ) {
			System.out.println("Error : "+e.getMessage());
		}
		
	}
	
	public static void Printfile() {
		
		try(BufferedReader br = new BufferedReader(new FileReader("Accounts.txt"))){
			
			String line;
			while((line = br.readLine())!= null) {
				
				System.out.println(line);
				
			}
		}catch(Exception e) {
			
			System.out.println("ERROR : "+e.getMessage());
		}
	}
	
	
	
	
}

public class Question4_1 {
    public static void main(String[] args) {
        // Create a Premium Account (PA)
        PA account = new PA("ACC001", "Sridhar", 5000);

        // Display account details
        System.out.println("=== Initial Account Details ===");
        account.DisplayAccDetails();

        // Deposit money
        System.out.println("\n=== Deposit Transaction ===");
        account.deposit(2000);

        // Withdraw money with exception handling
        System.out.println("\n=== Withdrawal Transaction ===");
        try {
            account.withdrawal(1000000);
            System.out.println("Withdrawal successful. Current Balance: " + account.Balance);
        } catch (Exception e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
        
        // Calculate interest
        System.out.println("\n=== Interest Calculation ===");
        double interest = account.CalculateIntrest();
        System.out.println("Interest earned: " + interest);

        // Generate account statement (final method)
        System.out.println("\n=== Account Statement ===");
        account.generateSTATEMENT();

        // Save account details to file
        System.out.println("\n=== Saving Account to File ===");
        account.saveUp();

        // Print file contents
        System.out.println("\n=== Reading Accounts.txt ===");
        PA.Printfile();
    }
}

