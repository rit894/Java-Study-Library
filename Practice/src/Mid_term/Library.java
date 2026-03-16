package Mid_term;
class Author{
	
	private String AuthorID;
	private String  name;
	private String Nationality;
	
	public Author(String id,String n, String na) {
		AuthorID = id;
		name = n;
		Nationality =na;
	}
	public void displayAuthorDetails(){
		
	System.out.println(AuthorID);
	System.out.println(name);
	System.out.println(Nationality);
	
	}
}

class Book{
	static int count = 0;
	private String ID;
	private String name;
	private String genre;
	private Author author;
	
	public Book(String i, String n, String g, Author a) {
		ID = i;
		name = n;
		genre = g;
		author = a;
		count++;
		
		
	}
	
	public void displayBookDetails() {
		System.out.println(ID);
		System.out.println(name);
		System.out.println(genre);
		author.displayAuthorDetails();
	}
	
}
public class Library {

	public static void main(String[] args) {
		
		Author a1 = new Author("123","Rithwik","Korean");
		Book b1 = new Book("456","The peotry","cosmic",a1);
		
		b1.displayBookDetails();
		
		

	}

}
