package Package1;

import java.io.*;

abstract class  book{
	protected int id;
	protected String title;
	protected String BorrowerName;
	protected int daysBorrowed;
	
	public book(int i, String a, String b, int d) {
		id = i;
		title = a;
		BorrowerName = b;
		daysBorrowed = d;
		
	}
	
	public void DisplayDetails () {
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(BorrowerName);
		System.out.println(daysBorrowed);
		
	}
	public double ComputeFine() {
		return daysBorrowed *2;
	}
	
	abstract void calculatefine();
	
}

class ReferenceBook extends book implements Auditable{
	
	private boolean isbookAvialable = false;
	final int  MAX_BORROW_DAYS = 3;
	
	private int maxAllowedDays =3;

	public ReferenceBook(int i, String a, String b, int d) {
		super(i, a, b, d);
		
	}
	
	public void Displaydetails() {
		super.DisplayDetails();
		if(daysBorrowed> maxAllowedDays) {
			double fine = (daysBorrowed *10)+ super.ComputeFine();
			System .out.println("Fine : "+ fine);
			System.out.println(maxAllowedDays);
		}
		System.out.println("FIne : "+super.ComputeFine());
		System.out.println(maxAllowedDays);
	}

	@Override
	void calculatefine() {
		if(daysBorrowed> maxAllowedDays) {
			double fine = (daysBorrowed *10)+ super.ComputeFine();
			System .out.println("Fine : "+ fine);
			System.out.println(maxAllowedDays);
		}
		System.out.println("FIne : "+super.ComputeFine());
		System.out.println(maxAllowedDays);
		
	}

	@Override
	public void logTransaction() {
		
		try(FileWriter fw = new FileWriter("BookTransactions.txt",true);
				PrintWriter pw = new PrintWriter(fw)){
			pw.println("Book id : "+ id+" | Book title  : "+ title+ " | Borrower Name : "+ BorrowerName
					+"Is book taken : "+isbookAvialable);
			
		} catch(Exception e) {
			System.out.println("Error : "+ e.getMessage());
		}
		
		
		
	}
	
	public static void StartUp() {
		try(BufferedReader br = new BufferedReader(new FileReader("BookTransactions.txt"))){
			String line;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
		} catch(Exception e) {System.out.println("Error : "+ e.getMessage());}
		
	}

	@Override
	public void lendable(int days) throws Exception {
		if(! isbookAvialable) {
		if(days> MAX_BORROW_DAYS) {
			throw new Exception("Excedding the MAX_BORROW_DAYS");
		}
		System.out.println("Book is avaible and is sucsesfully borrowed");
		isbookAvialable = true;}
		throw new Exception("Book is already Borrowed");
	}

	@Override
	public void Auditabl() {
		
		
	}
	
	public void MemberSummary() {
		DisplayDetails();
		System.out.println("Is Book taken : "+ isbookAvialable);
	}
	
}

public class Question2 {

	public static void main(String[] args) {
		
		try {
		ReferenceBook rb = new ReferenceBook(123,"Java Advanced","pandhi",5);
		
		rb.Displaydetails();
		try {
			rb.lendable(1);
		}catch(Exception e) { System.out.println("Error: "+ e.getMessage());}
		try {
			rb.logTransaction();
		}catch(Exception e) {System.out.println("Error : "+e.getMessage());}
		
		ReferenceBook.StartUp();
		rb.MemberSummary();
		} catch (Exception e) {
			System.out.println("ERROR : "+ e.getMessage());
		}

		

	}

}
