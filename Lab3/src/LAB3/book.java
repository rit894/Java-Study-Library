package LAB3;
class pig{
	private String title;
	private String author;
	private double price;
	
	
	
	public pig() {
		title = "Unknown";
		author = "unkown";
		price = 0.0;
	}
	
	
	public pig( String t , String a , double p) {
		title=t;
		author = a ;
		price = p ;
	}
	public void  setDetails( String t, String a, double p) {
		title = t;
		author = a;
		price = p ; 
	}
	public void displayDetails() { 
		System.out.println("Title : " + title); 
		System.out.println("Author : " + author); 
		System.out.println("Price : " + price); 
		System.out.println("---------------------------"); }
}
public class book {

	public static void main(String[] args) {
		pig book1 = new pig();
		book1.displayDetails();
		pig book2 = new pig("Alchimest","hi",600);
		book2.displayDetails();
		book1.setDetails("hurie", "hi",880 );
		book1.displayDetails();

	}

}
