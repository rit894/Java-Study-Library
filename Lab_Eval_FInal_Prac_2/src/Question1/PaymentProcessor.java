package Question1;

public interface PaymentProcessor {
	
	public void processPayment(String rideId, double amount);
	public void issueRefund(String rideId, double amount);

}
