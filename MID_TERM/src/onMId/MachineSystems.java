package onMId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Machine{
	
	private String ID;
	private String name;
	private int PCH;
	private int CPC;
	private String status;
	
	
	public Machine(String id,String n, int p, int c,String S) {
		ID =id; 
		name =n;
		PCH = p;
		CPC = c;
		status =S;
		
	}
	
	public int getCPC() {
		return CPC;
	}
	public String getname() {
		return name;
	}
	public void setstatus(String a) {
		status = a;
	}
	public void displaydetails() {
		System.out.println();
		System.out.println("=============");
		System.out.println(ID);
		System.out.println(name);
		System.out.println(PCH);
		System.out.println(CPC);
		System.out.println(status);
	}
	
	
}

public class MachineSystems {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		ArrayList<Machine>machines =new ArrayList<>();
		while(true){
			System.out.println("choose from the following menu"
					+ "1.Store a machine details \n2.Display all machines\n"
					+ "3.highest production machine\n 4.stop a faulty machine\n 5.Total production of factory"
					+ "\n6.Stop");
			int choosing = obj.nextInt();
			obj.nextLine();
			
			if (choosing==1) {
				Machine m1 = new Machine("123","m1",12,15,"yes");
				Machine m2 = new Machine("456","m2",15,0,"yes");
				Machine m3 = new Machine("789","m3",10,25,"yes");
				machines.add(m3);
				machines.add(m2);
				machines.add(m1);
			}
			else if (choosing==2) {
				for(Machine M:machines) {
					M.displaydetails();
					
				}
			}
			else if (choosing==3) {
				ArrayList<Integer> PC =  new ArrayList<>();
				for(Machine M:machines) {
					PC.add(M.getCPC());
				}
				int max = Collections.max(PC);
				
				for(Machine M:machines) {
					if(M.getCPC()==max) {
						System.out.println("max highest production machine:"+M.getname()+"with production of"+max);
						
					}
				}
				
				
			}else if(choosing==4) {
				ArrayList<Integer> PC =  new ArrayList<>();
				for(Machine M:machines) {
					if(M.getCPC()==0) {
						System.out.println("machine: "+M.getname()+"\n PCP = 0");
						M.setstatus("no");
						M.displaydetails();
						
					}
				}
				
				
			}else if(choosing ==5) {
				ArrayList<Integer> PC =  new ArrayList<>();
				int sum =0;
				for(Machine M:machines) {
					sum+=M.getCPC();
					
				}
				System.out.println("Total production is --" + sum);
				
				
			}else if (choosing==6) {
				break;
			}
			
			
			
		}

	}

}
