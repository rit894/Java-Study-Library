package Package1;
import java.util.*;

class event {
	
	private String GuestName;
	private int TotalBudget;
	private int antendeeCount;
	
	public event(String g, int a, int b) {
		
		this.GuestName = g;
		TotalBudget = a;
		antendeeCount = b;
	}
	
	public String getname()throws NullPointerException {
		if(GuestName.equals(" ")|| GuestName==null) {
			throw new NullPointerException("Invalid GuestName");
		}
		
		return GuestName;
	}
	
	public int costPerPerson()  throws ArithmeticException{
		if(antendeeCount == 0) {
			throw new ArithmeticException("NOt divisible by 0");
		}
		return TotalBudget/antendeeCount;
	}
	
	
	String[] List1 =new String[5];
	
	public String ManageSeating(int n) throws ArrayIndexOutOfBoundsException{
		
		if(n>List1.length) {
			throw new ArrayIndexOutOfBoundsException("Index out Range");
		}
		 return  List1[n];
	}
	
	
	
}

public class Q1 {

	public static void main(String[] args) {
		try {
		event e1 = new event(" ",10,20);
		event e2 = new event("geeta",100,0);
		
		
		try {
			e1.getname();
			
		}catch(NullPointerException e) {
			System.out.println("Error : "+ e.getMessage());
		}
		try {
			e2.costPerPerson();
			
		}catch(ArithmeticException e) {
			System.out.println("Error : "+ e.getMessage());
		}
		
		try {
			e1.ManageSeating(6);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error : "+ e.getMessage());
		}
		
		
		
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		
	
		
	

	}

}
