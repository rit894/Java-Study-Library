package PRAC;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;

    // No-argument constructor
    public Book() {
        bookId = "NONE";
        title = "None";
        author = "none";
        isIssued = false;
    }

    // Parameterized constructor
    public Book(String b, String t, String a) {
        bookId = b;
        title = t;
        author = a;
        isIssued = false;
    }

    // Issue book
    public boolean issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("The book has been issued successfully.");
            return true;
        } else {
            System.out.println("The book is already issued.");
            return false;
        }
    }

    // Return book
    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("The book has been returned successfully.");
        } else {
            System.out.println("The book was not issued.");
        }
    }

    // Display details
    public void displayDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Book ID   : " + bookId);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Is Issued : " + (isIssued ? "Yes" : "No"));
        System.out.println("---------------------");
    }
}

public class Library_System {
    public static void main(String[] args) {
        // Create books
        Book b1 = new Book();
        Book b2 = new Book("101", "Java Basics", "James Gosling");

        // Display details
        b1.displayDetails();
        b2.displayDetails();

        // Issue and return operations
        b2.issueBook();
        b2.displayDetails();

        b2.returnBook();
        b2.displayDetails();
    }
}
