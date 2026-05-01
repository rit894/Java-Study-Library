package prac3;
import java.util.*;
import java.io.*;



abstract class Course {
    protected String courseId;
    protected String courseName;
    protected int duration;

    public Course(String courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseDetails() {
        System.out.println("--- Course Details ---");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}


class PremiumCourse extends Course implements EnrollmentServices {
    private String mentorName;
    private boolean certificateProvided;
    private ArrayList<String> enrolled = new ArrayList<>();
    final int MAX_STUDENTS = 50;
    int fees;

    public PremiumCourse(String courseId, String courseName, int duration, String mentorName, boolean certificateProvided) {
        super(courseId, courseName, duration);
        this.mentorName = mentorName;
        this.certificateProvided = certificateProvided;
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Mentor: " + mentorName);
        System.out.println("Certificate Included: " + (certificateProvided ? "Yes" : "No"));
    }

    @Override
    public void enrollStudents(String stName) throws Exception {
        if (enrolled.size() >= MAX_STUDENTS) {
            throw new Exception("Enrollment failed: Course is full!");
        } else {
            enrolled.add(stName);
            System.out.println(stName + " has been enrolled in the Premium course.");
        }
    }

    @Override
    public void removeStudent(String stName) {
        if (enrolled.remove(stName)) {
            System.out.println(stName + " has been removed from the Premium course.");
        } else {
            System.out.println(stName + " was not found in the list.");
        }
    }

    public void feeAmount(int fees) throws Exception {
        if (fees <= 0) {
            throw new Exception("Invalid Fee amount: Must be greater than 0.");
        }
        this.fees = fees;
        System.out.println("Fee of " + fees + " added successfully.");
    }

    final public void generateProgressReport() {
        System.out.println("\n--- Progress Report ---");
        displayCourseDetails();
        System.out.println("Total Fees: $" + fees);
        System.out.println("Enrolled Students: " + enrolled);
    }

    public void saveAsFile() {
       
        try (FileWriter fw = new FileWriter("Courses.txt", true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println("Course ID: " + courseId + " | Name: " + courseName + 
                        " | Duration: " + duration + " | Fee: " + fees);
            System.out.println("Course saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save to file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        File file = new File("Courses.txt");
        if (!file.exists()) {
            System.out.println("No saved records found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Courses.txt"))) {
            String line;
            System.out.println("\n--- Loading Records from File ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Failed to load the file: " + e.getMessage());
        }
    }
}

public class Question4 {
    public static void main(String[] args) {
        try {
            
            PremiumCourse proCourse = new PremiumCourse("CS500", "Advanced AI & ML", 60, "Dr. Smith", true);

            
            proCourse.feeAmount(1500);
            proCourse.enrollStudents("Alice");
            proCourse.enrollStudents("Bob");

            
            proCourse.generateProgressReport();
            proCourse.saveAsFile();

            
            PremiumCourse.readFromFile();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}