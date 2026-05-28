package Package1;
import java.util.*;

abstract class StaffMember {
	
	protected String name;
	protected String Eid;
	protected String dept;
	public StaffMember(String name, String eid, String dept) {
		
		this.name = name;
		Eid = eid;
		this.dept = dept;
	}
	
	public void DisplayInfo() {
		
		System.out.println("Name : "+name);
		System.out.println("Employee ID : "+Eid);
		System.out.println("Department : "+dept);
		
	}
	
	abstract double CalculateAnnualSalary();
	
	
	

	
	
	
}

class professor extends StaffMember implements Question1Interface {
	
	protected double BaseSalary;
	protected double ResearchAllowance;
	

	public professor(String name, String eid, String dept,double a,double b) {
		super(name, eid, dept);
		BaseSalary = a;
		ResearchAllowance = b;
		
	}


	@Override
	double CalculateAnnualSalary() {
		
		return  12* BaseSalary +ResearchAllowance ;
		
		
	}
	
	public void DisplayInfo() {
		super.DisplayInfo();
		System.out.println("Base Salary : "+ BaseSalary);
		System.out.println("Research Allowance : "+ResearchAllowance);
		System.out.println("Anual Salary : "+ CalculateAnnualSalary());
		
	}


	@Override
	public double CalaculateTax(double a) {
		
		
		a = this.CalculateAnnualSalary();
		
		if (a>80000) {
			
			return 0.3*a;
			
		}
		return 0.2*a;
		
	}
	
	
	
	
}

class Lecturer extends StaffMember  implements Question1Interface{
	
	protected double hourlyRate ;
	protected int  hoursPerWeek ;
	

	public Lecturer(String name, String eid, String dept,double hr, int hpw) {
		super(name, eid, dept);
		hourlyRate = hr;
		hoursPerWeek = hpw;
		
		
	}


	@Override
	double CalculateAnnualSalary() {
		
		return hourlyRate * hoursPerWeek * 52;
	}
	
	public void DisplayInfo() {
		super.DisplayInfo();
		System.out.println("Anual Salary : "+ CalculateAnnualSalary());
		
	}


	@Override
	public double CalaculateTax(double a) {
		a= this.CalculateAnnualSalary();
		if(a>40000) {
			return 0.15 * a;
		}
		
		return 0.1*a;
	}
	
	
	
	
	
	
}

public class Question1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
