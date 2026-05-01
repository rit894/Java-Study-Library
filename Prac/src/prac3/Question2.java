package prac3;
import java.io.*;



abstract class Patient1 {

    final int MIN_STAY_DAYS = 1;

    protected int PatientId;
    protected String Name;
    protected String Disease;

    public Patient1(int Id, String name, String Disease) {
        this.PatientId = Id;
        this.Name = name;
        this.Disease = Disease;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + PatientId);
        System.out.println("Name: " + Name);
        System.out.println("Disease: " + Disease);
    }

    abstract int calculateBill();

    // FINAL METHOD
    public final void generateBillSummary() {
        System.out.println("=== BILL SUMMARY ===");
        System.out.println("Patient ID: " + PatientId);
        System.out.println("Name: " + Name);
        System.out.println("Disease: " + Disease);
        System.out.println("Total Bill: " + calculateBill());
    }
}




	class ICUP1 extends Patient1 implements MedicalService {

	    String AssignedDoc;
	    int DCareCharge;
	    String AppDate;
	    int Staydays = 10;

	    public ICUP1(int Id, String name, String Disease, String Asd, int DCC) {
	        super(Id, name, Disease);   // super keyword
	        this.AssignedDoc = Asd;
	        this.DCareCharge = DCC;
	    }

	    @Override
	    public void displayPatientDetails() {
	        super.displayPatientDetails();
	        System.out.println("Assigned Doctor: " + AssignedDoc);
	        System.out.println("Daily Care Charge: " + DCareCharge);
	    }

	    @Override
	    int calculateBill() {
	        return Staydays * DCareCharge;
	    }

	    // Stay days validation
	    public void setStayDays(int days) throws Exception {
	        if (days < MIN_STAY_DAYS) {
	            throw new Exception("Invalid stay duration.");
	        }
	        this.Staydays = days;
	    }

	    @Override
	    public void ScheduleAppointment(String Date) throws Exception {
	        if (AssignedDoc == null || AssignedDoc.isEmpty()) {
	            throw new Exception("Doctor not assigned.");
	        }
	        AppDate = Date;
	        System.out.println("Appointment scheduled for: " + Date);
	    }

	    @Override
	    public void CancelAppointment(String Date) {
	        System.out.println("Appointment cancelled for: " + Date);
	    }

	    // FILE HANDLING — Write
	    public void saveToFile() {
	        try (FileWriter fw = new FileWriter("patients.txt", true);
	             PrintWriter out = new PrintWriter(fw)) {

	            out.println("Patient ID: " + PatientId +
	                        " | Name: " + Name +
	                        " | Disease: " + Disease +
	                        " | Bill: " + calculateBill());

	            System.out.println("Patient details stored in file.");

	        } catch (Exception e) {
	            System.out.println("File Error: " + e.getMessage());
	        }
	    }

	    // FILE HANDLING — Read
	    public static void readFromFile() {
	        try (BufferedReader br = new BufferedReader(new FileReader("patients.txt"))) {
	            String line;
	            System.out.println("=== STORED PATIENT RECORDS ===");
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (Exception e) {
	            System.out.println("File Read Error: " + e.getMessage());
	        }
	    }
	}



public class Question2 {
    public static void main(String[] args) {

        try {
            ICUP1 p = new ICUP1(101, "Meera", "Cardiac Arrest", "Dr. Sharma", 5000);

            p.displayPatientDetails();

            
            p.ScheduleAppointment("2026-05-10");
            p.CancelAppointment("2026-05-10");

            p.generateBillSummary();

            p.saveToFile();
            ICUP1.readFromFile();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
