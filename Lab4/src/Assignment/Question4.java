package Assignment;

import java.util.ArrayList;
import java.util.Collections;

class Student{
	
	private String name;
	private ArrayList<Integer> marks;
	
	public Student(String n , ArrayList<Integer> m) {
		 
		name = n;
		marks = m;
	}
	
	public ArrayList<Integer> getmarks() {
		return marks;
		
	}
	public String getname() {
		return name;
	}
	
	
	
}
public class Question4 {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Integer> marks1 = new ArrayList<>(); 
		marks1.add(85); 
		marks1.add(90); 
		marks1.add(78); 
		
		Student s1 = new Student("Kavin", marks1);
		
		ArrayList<Integer> marks2 = new ArrayList<>(); 
		marks2.add(88); 
		marks2.add(45); 
		marks2.add(56); 
		Student s2 = new Student("Karin", marks2);
		
		ArrayList<Integer> marks3 = new ArrayList<>(); 
		marks3.add(78); 
		marks3.add(46); 
		marks3.add(78); 
		Student s3 = new Student("vin", marks3);
		
		students.add(s3);
		students.add(s2);
		students.add(s1);
		
		
		
		for (Student j : students) {
			
			ArrayList<Integer> m = j.getmarks();
			String n = j.getname();
			double sum =0.0;
			for (int i : m ) {
				sum+=i;
				
			}
			 double avg = sum/3.0;
			 System.out.println(n+ "  avg is :"+ avg );
			 
			
			
			
		}
		
		
		
		

	}

}
