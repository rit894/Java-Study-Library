package Mid_term;

import java.util.ArrayList;
class patient{
	
	private String PatientID;
	private String name;
	
	public patient(String s, String n) {
		PatientID = s;
		name = n;
		
	}
	
	public void displayPatientDetails() {
		System.out.println("Patient ID : "+PatientID);
		System.out.println("Name : "+name);
		
	}
	
	
}

class Doctor{
	static int count = 0;
	
	private String ID;
	private String name;
	
	public Doctor(String s , String n) {
		
		ID = s;
		name = n;
		count++;
	}
	
	
	private ArrayList<patient>Patients = new ArrayList<>();
	
	public void addPatient(patient P) {
		
		Patients.add(P);
		
		
		
	}
	
	
	public void Doctors_count() {
		
		System.out.print(count);
	}
	
	public void displayDoctorDetails() {
		
		System.out.println(ID);
		System.out.println(name);
		for(int i=0;i<Patients.size();i++) {
		patient p= Patients.get(i);
		p.displayPatientDetails();
		}
		
	}
	
	
}

public class Hospital {

	public static void main(String[] args) {
		patient p1 = new patient("5264","Jhon");
		patient p2 = new patient("1234","Rithika");
		
		Doctor D1 = new Doctor("741","rithwik");
		D1.addPatient(p1);
		D1.displayDoctorDetails();
		
	}

}
