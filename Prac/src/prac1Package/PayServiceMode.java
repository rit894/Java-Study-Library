package prac1Package;

public interface PayServiceMode {

	String CheckBalance();
	int AccountDetails();
	boolean processPayments(int ammount);
	String processRefund(int amount);
		
}
