package prac2;



 abstract class ACCOUNT{
	 
	 final  double MIN_BALANCE = 1000.00;
	
	 int accNum;
	 String name;
	 double Balance;
	
	public ACCOUNT(int accn, String n, double b) {
		this.accNum = accn;
		this.name= n;
		this.Balance = b;
		
	}
	
	public void displayAccountDetails() {
		System.out.println("===========");
		System.out.println("BANK ACCOUNT DETAILS");
		System.out.println("===========");
		System.out.println("Account NUmber : "+ accNum);
		System.out.println("Account Holder Name : "+ name);
		System.out.println("CUrrent Balance: "+Balance);
		
	}
    public final void generateStatement() {
        System.out.println("Generating Account Statement...");
        System.out.println("Account Number: " + accNum);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + Balance);
    }
	
	abstract double CalaculateInstrest();
		
	
	
	
}

class PremiumAccount extends ACCOUNT implements TransactionService{
	
	private double WithdrawalLimit;

	public PremiumAccount(int accn, String n, double b, double w) {
		super(accn, n, b);
		this.WithdrawalLimit = w;
		
	}
	
	public void displayAccountDetails() {
		System.out.println("===========");
		System.out.println("BANK ACCOUNT DETAILS");
		System.out.println("===========");
		System.out.println("Account NUmber : "+ accNum);
		System.out.println("Account Holder Name : "+ name);
		System.out.println("CUrrent Balance: "+Balance);
		System.out.println("Withdral Limit : "+ WithdrawalLimit);
		
	}

	@Override
	 public double CalaculateInstrest() {
		
		return (Balance *0.05);
		
	}

	@Override
	public void deposit(double amount) {
		
		Balance+=amount;
		System.out.println("Balance After Deposite : "+Balance);
		
	}

	@Override
	public void withdraw(double ammount) throws Exception {
		
		if(ammount>WithdrawalLimit) {
			throw new Exception ("Withdrwal Exceeds Limit");
			
		}
		if(Balance-ammount <MIN_BALANCE) {
			
			throw new Exception("Cannot withdraw > Balnace would fall beyond MInimum Balance");
		}
		Balance-=ammount;
		System.out.println("Balance After Withdrwal : "+Balance);
		
	}
	
	
	
}



public class Question1 {
    public static void main(String[] args) {
        try {
            // Create a PremiumAccount object
            PremiumAccount pAcc = new PremiumAccount(2001, "Ananya", 50000, 100000);

            // Display account details (overridden method)
            pAcc.displayAccountDetails();

            // Perform transactions
            pAcc.deposit(5000);          // adds money
            pAcc.withdraw(2000);         // subtracts money safely

            // Show interest calculation
            System.out.println("Interest: " + pAcc.CalaculateInstrest());

            // Generate account statement (final method)
            pAcc.generateStatement();

        } catch (Exception e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
    }
}

