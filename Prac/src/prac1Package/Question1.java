package prac1Package;
import java.util.ArrayList;


class baseWork implements PayServiceMode{
	
	int CardNumber;
	int balance;
	
	String ServiceType;
	
	public baseWork ( int Card,String Service) {
		
		CardNumber = Card;
		balance = 5000;
		ServiceType = Service;
		
	}
	@Override
	public String CheckBalance() {
		
		return " Current Holding's : "+balance;
		
	}

	@Override
	public int AccountDetails() {
		
		return CardNumber;
				
	}
	@Override
	public boolean processPayments(int ammount) {
		if(ammount<balance) {
			balance-=ammount;
			
			return true;
		}
		return false;
	}
	@Override
	public String processRefund(int amount) {
		
		balance+=amount;
		return"REfund is succesfull";
		
	}
		
}

class CreditCard extends baseWork{
	
	int limit;

	public CreditCard(int Card,int limit) {
		super(Card, "CreditCard");
		this.limit = limit;
		
		
	}
	
	public boolean limitReached() {
		
		if (balance<= limit) {
			
			return true;
			
		}
		return false;
		
	}
}

class DigitalWallet extends baseWork{

	public DigitalWallet(int Card) {
		super(Card, "Digital Wallet");
		
	}
	
	public String userAuthentication(int cardnum) {
		
		if (cardnum==CardNumber) {
			
			return "Verified";
		}
		return "Verification Unsuccesfull";
	}
	
	
}

class BankTransfer extends baseWork{

	public BankTransfer(int Card) {
		super(Card, "Bank Transfer");
		
	}
	
	
}

class Account {
	
	String name;
	ArrayList<PayServiceMode> Options ;
	
	public Account(String n) {
		this.name = n;
		this.Options =new ArrayList<>();
		
		
	}
	
	public void addOptions(PayServiceMode option) {
		Options.add(option);
	}
	public void makePayment(PayServiceMode method, int ammount) {
		
		if(method.processPayments(ammount)) {
			System.out.println("payment of "+ ammount+ "successfull via"+method.getClass().getSimpleName());
			
		}else {
			System.out.println("Payment failed.");
		}
	}
	public void refund(PayServiceMode method, int amount) {
		System.out.println(method.processRefund(amount));
	}
	
}




public class Question1 {
    public static void main(String[] args) {
        Account acc = new Account("Sridhar");

        CreditCard cc = new CreditCard(12345, 2000);
        DigitalWallet dw = new DigitalWallet(67890);
        BankTransfer bt = new BankTransfer(54321);

        acc.addOptions(cc);
        acc.addOptions(dw);
        acc.addOptions(bt);

        // Switch between methods dynamically
        acc.makePayment(cc, 1000);   // Credit card payment
        acc.makePayment(dw, 500);    // Wallet payment
        acc.refund(bt, 300);         // Bank transfer refund
    }
}

