package prac3;

class Patient {
	
	protected int PatientId;
	 protected String Name;
	protected String Disease;
	
	public Patient(int Id, String name,String Disease){
		this.PatientId = Id;
		this.Name = name;
		this.Disease  = Disease;
		
	}
	public void displayPatientDetails(){
		
		System.out.println(PatientId);
		System.out.println(Name);
		System.out.println(Disease);
		
		
	}
	public void CancelAppointment(String Date) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class ICUP extends Patient{
	
	String AssignedDoc;
	String DCareCharge;

	public ICUP(int Id, String name, String Disease,String Asd,String DCC) {
		
		super(Id, name, Disease);
		this.AssignedDoc = Asd;
		this.DCareCharge = DCC;
	}
	
	public void displayPatientDetails(){
		
		System.out.println(PatientId);
		System.out.println(Name);
		System.out.println(Disease);
		System.out.println(AssignedDoc);
		System.out.println(DCareCharge);
		
		
		
	}
	
}


public class Question1 {

	public static void main(String[] args) {
		
		Patient p1 = new Patient(123,"Rithwik","Asthama");
		ICUP I1 =new ICUP(1234, "Sathwik","Panic Attack","Rithwik","DHanesh");
		
		p1.displayPatientDetails();
		I1.displayPatientDetails();
		

	}

}
