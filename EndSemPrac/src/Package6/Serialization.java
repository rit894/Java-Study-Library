package Package6;

import java.io.*;

class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String name;
	int rollno;
	double cgpa ;
	public Student(String name, int rollno, double cgpa) {
		
		this.name = name;
		this.rollno = rollno;
		this.cgpa = cgpa;
	}
	public String toString() {
		return name + " | Roll number : " + rollno + " | CGPA : "+ cgpa;
		
	}
	
	
}

public class Serialization {

	public static void main(String[] args) {
		
		Student S = new Student("rithwik",25361,8.05);
		ObjectOutputStream pack = null;
		try {
			pack = new ObjectOutputStream(new FileOutputStream("Student.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pack.writeObject(S);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pack.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Student profile saved ");
		
		ObjectInputStream unpack = null;
		try {
			unpack = new ObjectInputStream(new FileInputStream("Student.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student loaded = null;
		try {
			loaded = (Student)unpack.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			unpack.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loaded);
		
		

	}

}
