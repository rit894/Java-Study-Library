package PRAC;
class Student{
	private String name;
	private String rollNumber;
	private double  marks;
	
	public Student() {
		name = "UNKOWN";
		rollNumber = "Unknown";
		marks = 0.0;
	}
	
	
	public Student(String n, String r, double m) {
		name = n;
		rollNumber = r;
		marks = m;
	}
	public void updateMarks(double n) {
		marks=n;
		
	}
	public void displayStudentDetails() {
		
		System.out.println(name);
		System.out.println(rollNumber);
		System.out.println(marks);
	}
	
}

public class Student_Managment {

	public static void main(String[] args) {
		Student student1=new Student();
		student1.displayStudentDetails();
		
		Student student2 = new Student("hi","bitch",0.0);
		student2.displayStudentDetails();

	}

}
