package prac3;
import java.util.*;
import java.io.*;

// 2. Interface for Medical Services
interface MedicalService1 {
    void scheduleAppointment(String date) throws Exception;
    void cancelAppointment(String date);
}

// 1. Abstract Base Class: Patient
abstract class Patient1 {
    protected String patientId;
    protected String patientName;
    protected String disease;

    public Patient1(String patientId, String patientName, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.disease = disease;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Disease: " + disease);
    }

    // Abstract method for billing
    abstract public double calculateBill(int days) throws Exception;
}

// 3. Derived Class: ICUPatient
class ICUPatient1 extends Patient1 implements MedicalService1 {
    private String assignedDoctor;
    private double dailyCareCharge;
    
    // 5. Final variable
    final int MIN_STAY_DAYS = 1;

    public ICUPatient1(String patientId, String patientName, String disease, String doctor, double charge) {
        // 4. Use of super keyword
        super(patientId, patientName, disease);
        this.assignedDoctor = doctor;
        this.dailyCareCharge = charge;
    }

    @Override
    public void displayPatientDetails() {
        super.displayPatientDetails();
        System.out.println("Assigned Doctor: " + assignedDoctor);
        System.out.println("Daily Care Charge: " + dailyCareCharge);
    }

    @Override
    public double calculateBill(int days) throws Exception {
        // 7. Exception Handling for stay duration
        if (days < MIN_STAY_DAYS) {
            throw new Exception("Invalid stay duration.");
        }
        return days * dailyCareCharge;
    }

    @Override
    public void scheduleAppointment(String date) throws Exception {
        // 7. Exception Handling for doctor assignment
        if (assignedDoctor == null || assignedDoctor.isEmpty()) {
            throw new Exception("No doctor assigned for this patient.");
        }
        System.out.println("Appointment scheduled for: " + date);
    }

    @Override
    public void cancelAppointment(String date) {
        System.out.println("Appointment cancelled for: " + date);
    }

    // 6. Final method for summary
    final public void generateBillSummary(int days) {
        try {
            System.out.println("Generating Bill Summary...");
            double total = calculateBill(days);
            displayPatientDetails();
            System.out.println("Total Bill for " + days + " days: " + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 8. File Handling: Save to file
    public void saveToFile(int days) {
        try (FileWriter fw = new FileWriter("patients.txt", true);
             PrintWriter out = new PrintWriter(fw)) {
            double bill = calculateBill(days);
            out.println("Patient ID: " + patientId + " | Name: " + patientName + 
                        " | Disease: " + disease + " | Bill: " + bill);
            System.out.println("Patient details stored in file.");
        } catch (Exception e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // 8. File Handling: Read from file
    public static void readFromFile() {
        System.out.println("Reading patient records from file...");
        try (BufferedReader br = new BufferedReader(new FileReader("patients.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

// 9. Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        try {
            // Create ICU Patient
            ICUPatient1 p2 = new ICUPatient1("P002", "Meera", "Cardiac Arrest", "Dr. Sharma", 5000);
            System.out.println("Patient record created successfully.");

            // Appointment Operations
            p2.scheduleAppointment("2025-06-10");
            p2.cancelAppointment("2025-06-10");

            // Billing Summary
            p2.generateBillSummary(5);

            // Demonstrate Exception: Invalid stay duration
            try {
                p2.calculateBill(0);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Demonstrate Exception: No Doctor (using a temporary object)
            try {
                ICUPatient1 pEmpty = new ICUPatient1("P003", "Test", "Flu", "", 1000);
                pEmpty.scheduleAppointment("2025-07-01");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // File Operations
            p2.saveToFile(5);
            ICUPatient1.readFromFile();

        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
    }
}