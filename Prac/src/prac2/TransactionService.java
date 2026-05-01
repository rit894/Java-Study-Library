package prac2;

public interface TransactionService {
	
	void deposit(double amount);
	void withdraw(double ammount)  throws Exception;

}
