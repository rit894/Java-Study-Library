package Mid_term;
import java.util.ArrayList;
import java.util.Scanner;

class Room{
	
	private String roomNum;
	private String type;
	private String PPN;
	private String avaliablity;
	
	public Room(String r, String t, String p,String av) {
		roomNum = r;
		type = t;
		PPN = p;
		avaliablity = av;
		
	}
	
	public String getAvaliabilty() {
		return avaliablity;
	}
	public String getroomnumber() {
		return roomNum;
	}
	
	public void displaydetails() {
		System.out.println(roomNum);
		System.out.println(type);
		System.out.println(PPN);
		System.out.println(avaliablity);
		
	}
	


	
	
}
class resevor{
	private String Id;
	private String name;
	private String Contact;
	
	public resevor(String id,String n , String c ) {
		Id = id;
		name = n;
		Contact = c;
		
	}
	
}



public class HotelBookingSystem {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		ArrayList<Room> rooms = new ArrayList<>();
		Room r1 = new Room("101", "Luxury", "2000", "yes");
		Room r2 = new Room("102", "Economy", "1000", "no");
		Room r3 = new Room("103", "Luxury", "2500", "yes");
		
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		
		resevor c1 = new resevor("12","rithwik","contact") ;
		
		System.out.println("WELCOME CUSTAMORE ");
		
		while(true) {
			System.out.println("Enter the from the fooloing Menu : 1.Available rooms"
					+ "2.Book a Room  3.break");
			int choosing = obj.nextInt();
			obj.nextLine();
			if(choosing==1) {
		System.out.println("THe Avialable rooms are : ");
		for(Room a:rooms) {
			if(a.getAvaliabilty().equalsIgnoreCase("yes")) {
				a.displaydetails();
				System.out.println("===============");
				
			}
		}
			}
			else if(choosing==2) {
				
				System.out.println("Enter the Room Number you want to book : ");
				String rmno = obj.nextLine();
				boolean found = false;
				for(Room a:rooms) {
					if(a.getroomnumber().equalsIgnoreCase(rmno)) {
						if(a.getAvaliabilty().equalsIgnoreCase("yes")) {
							System.out.println("room Has been sucssefully booked.");
							found = true;
							break;
						}else {
							System.out.println("this room is preocupied  ");
						}
					}
						
					}if(!found) {
						System.out.print("this room number DNE");
						
					}
					
				}
			 else if (choosing==3){
				 
				 break;
				 
				
			}
				
				
			}
		
		}
		
		
		
		
	}


