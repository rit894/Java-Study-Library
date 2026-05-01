package PracQuestiopns;

import java.util.ArrayList;
import java.util.List;


interface Course {
    int getCourseDuration();       
    String getMode();              
    int getMaxStudents();        
    boolean enrollStudent(String studentName); 
    int getEnrolledCount();       
}


abstract class BaseCourse implements Course {
    protected int duration;
    protected int maxStudents;
    protected String mode;
    protected List<String> enrolledStudents;

    public BaseCourse(int duration, int maxStudents, String mode) {
        this.duration = duration;
        this.maxStudents = maxStudents;
        this.mode = mode;
        this.enrolledStudents = new ArrayList<>();
    }

    @Override
    public int getCourseDuration() {
        return duration;
    }

    @Override
    public String getMode() {
        return mode;
    }

    @Override
    public int getMaxStudents() {
        return maxStudents;
    }

    @Override
    public boolean enrollStudent(String studentName) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(studentName);
            return true;
        } else {
            System.out.println("Enrollment failed: capacity reached for " + mode + " course.");
            return false;
        }
    }

    @Override
    public int getEnrolledCount() {
        return enrolledStudents.size();
    }
}

// 3. Concrete course types
class ClassroomCourse extends BaseCourse {
    public ClassroomCourse(int duration) {
        super(duration, 60, "Classroom");
    }
}

class OnlineCourse extends BaseCourse {
    public OnlineCourse(int duration) {
        super(duration, 200, "Online");
    }
}

class HybridCourse extends BaseCourse {
    public HybridCourse(int duration) {
        super(duration, 100, "Hybrid");
    }
}

public class UniversityCourseSystem2 {
    public static void main(String[] args) {
    
        HybridCourse hybrid = new HybridCourse(12); 

        System.out.println("Course Mode: " + hybrid.getMode());
        System.out.println("Duration: " + hybrid.getCourseDuration() + " weeks");
        System.out.println("Max Students: " + hybrid.getMaxStudents());

       
        for (int i = 1; i <= 105; i++) {
            boolean success = hybrid.enrollStudent("Student" + i);
            if (!success) {
                System.out.println("Failed to enroll Student" + i);
            }
        }

        System.out.println("Total enrolled: " + hybrid.getEnrolledCount());
    }
}
