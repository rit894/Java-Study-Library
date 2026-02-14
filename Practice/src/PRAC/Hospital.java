package PRAC;
import java.util.Scanner;
import java.util.ArrayList;
class patient{
	private String patientId;
	private String name;
	private String disease;
	
	
	public patient(String id,String n,String d) {
		patientId=id;
		name = n;
		disease = d;
		
	}
	public String  getPatientsId() {
		
		return patientId;
		
	}
	public void setDisease(String d) {
		  disease = d;
	}
	public void displayDetails() {
		System.out.println(patientId);
		System.out.println(name);
		System.out.println(disease);
		
		
		
	}
}
public class Hospital {

	public static void main(String[] args) {
		ArrayList<patient> patients= new ArrayList<>();
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter the number of pateints you want to add: ");
		int n= obj.nextInt();
		obj.nextLine();
		int i =0;
		while(i<n) {
			
			System.out.print("Enter the patient id: ");
			String id = obj.nextLine();
			System.out.print("Enter the patients name : ");
			String na = obj.nextLine();
			System.out.print("Enter the disease of the patient : ");
			String di = obj.nextLine();
			patient p = new patient(id,na,di);
			patients.add(p);
			i++;
			
			 if (i==n) {
				System.out.print("Would you like add up the patients number (yes/no): ");
				String choose = obj.nextLine();
				 switch(choose) {
				 case "yes":
					 System.out.println("How many Would that be: ");
					 int ch = obj.nextInt();
					 obj.nextLine();
					 n+=ch;
				 case "No":
					 System.out.print("Thank you for Information!!!");
					 break;
					 
				 }
			}
			
		}
		System.out.println("Enter the search Id :");
		String ID = obj.nextLine();
		boolean found=false;
		for (patient j:patients) {
			String Id= j.getPatientsId();
			if (ID.equals(Id)) {
				j.displayDetails();
				found= true;
				break;
				
			}if(!found) {
				System.out.println("Account not found ....");
				
			}
			
		}
		
		System.out.println("Enter the patientId :");
		String pid = obj.nextLine();
		boolean found1 = false;
		for (patient k : patients) {
			String Pid = k.getPatientsId();
			if (pid.equals(Pid)) {
				
				System.out.println("Enter the new disease: ");
				String D = obj.nextLine();
				k.setDisease(D);
				k.displayDetails();
				found1 = true;
				break;
				
			} if (!found1) {
				System.out.println("ID not found ");
			}
	
		}
		for (patient l: patients) {
			l.displayDetails();
		}
		

	}

}
