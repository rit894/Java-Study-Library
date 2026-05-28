package Package5;

import java.io.*;

class BAnkAccount{
	protected String AccNum;
	protected String name;
	protected int pincode;
	protected double balance;
	protected boolean Status;
	public BAnkAccount(String accNum, String name, int pincode, double balance, boolean status) {
		
		AccNum = accNum;
		this.name = name;
		this.pincode = pincode;
		this.balance = balance;
		Status = status;
	}
	
	
	public void withdraw(int a) {
		
		balance -=a;
		System.out.println("Succsufully Withdrew : ");
		System.out.println("Current Holdings After Withdrwal is : "+ balance);
		
	}
	
public void Deposite(int a) {
		
		balance +=a;
		System.out.println("Succsufully Deposited : ");
		System.out.println("Current Holdings After Deposition  is : "+ balance);
		
	}

public void LoggIntoFile() {
	

	try(FileWriter fw = new FileWriter("Accounts2.txt",true);
			PrintWriter pw = new PrintWriter(fw)){
		
		pw.println("ACC NUM : "+AccNum+" | NAme : "+name);
		
		
		}catch(Exception e) {
			System.out.println("ERROR : "+ e.getMessage());
		}
	
	
	}

public static void RenderFile() {
	
	try(BufferedReader br = new BufferedReader(new FileReader("Accounts2.txt"))){
		
		String line;
		while((line= br.readLine())!=null) {
			
		
			System.out.println(line);
		}		
		
	}catch(Exception e) {
		
		System.out.println("Error : "+e.getMessage());
		
	}
	
	}

	
	

	


public void CheckBalance() {
	
	System.out.println(balance);
	
}





}

public class FileHandling {

	public static void main(String[] args) {
		
		
		BAnkAccount ba = new BAnkAccount("123","kfd",112,12333,false);
		
		ba.CheckBalance();
		ba.Deposite(123);
		ba.withdraw(1233);
		ba.LoggIntoFile();
		BAnkAccount.RenderFile();
		

	}

}
