package LAB3;
import java.util.Scanner;
import java.util.ArrayList;
class Flight{
	private String flightNumber;
	private String destination;
	private int seatAvailble;
	

public Flight(String fn, String des,int sa ) {
	flightNumber=fn;
	destination = des;
	seatAvailble = sa;
	
}
public String getflightNumber() {
	return flightNumber;
}
public void setSeatAvailable(int a) {
	seatAvailble = a;
}
public int getseatAvailable() {
	return seatAvailble;
}


public void displayDetails() {
	
	System.out.println(flightNumber);
	System.out.println(destination);
	System.out.println(seatAvailble);
	
}


}

public class Flight_App {

	public static void main(String[] args) {
		ArrayList<Flight> flights = new ArrayList<>();
		Scanner obj = new Scanner(System.in);
		int i =0;
		System.out.print(" Enter the number of flights you want to add more : ");
		int count = obj . nextInt();
		obj.nextLine();
		while(i<count) {
			System.out.print("Enter the flight number: ");
			String fn = obj.nextLine();
			System.out.print("Enter the Destination of the flight: ");
			String dt = obj.nextLine();
			System.out.print("Enter the number of seats avialble on the plane: ");
			int Sa = obj.nextInt();
			obj.nextLine();
			Flight f1 = new Flight(fn,dt,Sa);
			flights.add(f1);
			i++;
			if (i==count) {
				System.out.print("this was last time to add the last flight  would you like add any more of them:(yes/No) ");
				String choose =obj.nextLine();
				switch(choose) {
				case "yes":
					System.out.print("how may would that be ? ");
					int n =  obj .nextInt();
					obj.nextLine();
					count+=n;
				case "No":
					System.out.println("Thank you for information. the information will be shortly updated...");
					break;
				}
			
			
			
			
			
			
			
			
			
			
			}
			
			
		}
		System.out.println("Please enter the Search Flight number : ");
		String search = obj.nextLine();
		boolean found = false;
		for (Flight j:flights) {
			String jobj = j.getflightNumber();
			if (search.equals(jobj)) {
				j.displayDetails();
				found = true;
				break;
				}}
			 if (!found) {
				System.out.println("No detaail found");
			
		
			
		}
		
		
		System.out.println("Please the flightNumber you want to ride : ");
		String fnum = obj.nextLine();
		System.out.println("How many seats would you like to book : ");
		int sc = obj.nextInt();
		boolean found1 = false;
		for (Flight k:flights) {
			
			String fno = k.getflightNumber();
			int count1 = k.getseatAvailable();
			if (fnum.equals(fno) &&  count1>0) {
				found1 = true;
				int t = count1-sc;
				System.out.println("your "+sc+" seats have been succusfully booked");
				System.out.println("Total Reamaing Seats :"+t);
				break;
			}} if (!found1) {
				System.out .println("no details found on this flight");
			}
			
		}
		
	

}
