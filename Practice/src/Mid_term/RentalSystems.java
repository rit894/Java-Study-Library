package Mid_term;
import java.util.ArrayList;
import java.util.Scanner;
class car{
	private String Reg_no;
	private String model;
	private int RentalPricePerDay;
	protected String avialabilityStatus;
	
	public car(String r, String m,int RPR,String av) {
		
		Reg_no=r;
		model = m;
		RentalPricePerDay = RPR;
		avialabilityStatus = av;
		
		
	}
	
	public String getRegNo() {
		return Reg_no;
	}
	
	public void setavialabilityStatus(String s) {
		
		avialabilityStatus = s;
		
		
		
	}
	public String getavialabilityStatus() {
		return avialabilityStatus;
	}
	
	public void displayDetails() {
		System.out.println(Reg_no);
	}
	
	
	
	
	
	
}

class Customar{
	
	private String ID;
	private String name;
	private String phoneNumber;
	
	
	public Customar(String i, String n, String p) {
		ID=i;
		name = n;
		phoneNumber = p;
		
	}
	
}


public class RentalSystems {

	public static void main(String[] args) {
		
		Scanner obj =new Scanner(System.in);
		
		ArrayList<car> cars = new ArrayList<>();
		
		car lc1 = new car("456","L_1",45,"yes");
		car lc2 = new car("457","L_1",46,"yes");
		cars.add(lc2);
		cars.add(lc1);
		
		ArrayList<car>Avialable = new ArrayList<>();
		for(car C: cars) {
			
			if(C.avialabilityStatus.equalsIgnoreCase("yes")) {
				Avialable.add(C);
			}
			
		}
		System.out.println("Avialble Cars :");
		for(car C: Avialable) {
			C.displayDetails();
			
		}
		
		Customar c1 = new Customar("123","rithwik","789456123");
		System.out.println("Customar has been created");
		System.out.println("Do you want to rent a car? (Yes/No)");
		String choosing = obj.nextLine();

		if(choosing.equalsIgnoreCase("Yes")) {
			
			System.out.println("Avialble Cars :");
			for(car C: Avialable) {
				C.displayDetails();
				
			}
			System.out.println("Enter the Id of car : ");
			String choose = obj.nextLine();
			boolean found =false;
			for(car C: Avialable) {
				if(C.getRegNo().equalsIgnoreCase(choose)) {
					
					C.setavialabilityStatus("NO");
					System.out.println("your car has been rented sucssesfully..");
					found=true;
					break;
				}
					
			}if(!found) {
			    System.out.println("The entered registration number does not exist.");
			}
			
				
			}
			
			
		}
		
		
		
	}



