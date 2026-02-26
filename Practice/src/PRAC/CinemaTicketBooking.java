package PRAC;
import java.util.Scanner;
import java.util.ArrayList;

class Movie {
	
    private int movieId;
    private String movieName;
    private int totalSeats;
    private int bookedSeats;

    public Movie(int id, String mv, int ts, int bs) {
        this.movieId = id;
        this.movieName = mv;
        this.totalSeats = ts;
        this.bookedSeats = bs;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void bookSeats(int q) {
        this.bookedSeats += q;
    }

    public void cancelSeats(int q) {
        this.bookedSeats -= q;
    }

    public void displayDetail() {
        System.out.println("\n--- Movie Details ---");
        System.out.println("Movie ID      : " + movieId);
        System.out.println("Movie Name    : " + movieName);
        System.out.println("Total Seats   : " + totalSeats);
        System.out.println("Booked Seats  : " + bookedSeats);
        System.out.println("----------------------");
    }
}

public class CinemaTicketBooking {

    static ArrayList<Movie> movies = new ArrayList<>();
    static Scanner obj = new Scanner(System.in);

   
    public static void addMovie() {

        System.out.print("How many movies would you like to add: ");
        int count = obj.nextInt();
        obj.nextLine();

        int i = 0;

        while (i < count) {

            System.out.print("Enter Movie ID: ");
            int id = obj.nextInt();
            obj.nextLine();

            System.out.print("Enter Movie Name: ");
            String name = obj.nextLine();

            System.out.print("Enter Total Seats: ");
            int ts = obj.nextInt();
            obj.nextLine();

            System.out.print("Enter Booked Seats: ");
            int bs = obj.nextInt();
            obj.nextLine();

            movies.add(new Movie(id, name, ts, bs));
            i++;

            if (i == count) {
                System.out.print("Would you like to add more movies? (yes/no): ");
                String choose = obj.nextLine();

                if (choose.equalsIgnoreCase("yes")) {
                    System.out.print("How many more movies? ");
                    int extra = obj.nextInt();
                    obj.nextLine();
                    count += extra;  // extend loop
                }
            }
        }
    }

   
    public static void searchMovie() {

        System.out.print("Enter Movie Name to search: ");
        String Smovie = obj.nextLine();

        boolean found = false;

        for (Movie j : movies) {
            if (Smovie.equalsIgnoreCase(j.getMovieName())) {
                j.displayDetail();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No movie found with that name.");
        }
    }

    
    public static void bookSeats() {

        System.out.print("Enter Movie Name to book seats: ");
        String Smovie = obj.nextLine();

        boolean found = false;

        for (Movie j : movies) {
            if (Smovie.equalsIgnoreCase(j.getMovieName())) {

                int available = j.getTotalSeats() - j.getBookedSeats();
                System.out.println("Available Seats: " + available);

                System.out.print("Enter number of seats to book: ");
                int seats = obj.nextInt();
                obj.nextLine();

                if (seats <= available) {
                    j.bookSeats(seats);
                    System.out.println("Successfully booked " + seats + " seats.");
                    System.out.println("Remaining Seats: " + (available - seats));
                } else {
                    System.out.println("Not enough seats available.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found.");
        }
    }


    public static void cancelSeats() {

        System.out.print("Enter Movie Name to cancel seats: ");
        String Smovie = obj.nextLine();

        boolean found = false;

        for (Movie j : movies) {
            if (Smovie.equalsIgnoreCase(j.getMovieName())) {

                System.out.println("Currently Booked Seats: " + j.getBookedSeats());
                System.out.print("Enter number of seats to cancel: ");
                int seats = obj.nextInt();
                obj.nextLine();

                if (seats <= j.getBookedSeats()) {
                    j.cancelSeats(seats);
                    System.out.println("Successfully cancelled " + seats + " seats.");
                } else {
                    System.out.println("Cannot cancel more seats than booked.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found.");
        }
    }

   
    public static void main(String[] args) {

        addMovie();
        searchMovie();
        bookSeats();
        cancelSeats();

        System.out.println("\nThank you for using Cinema Ticket Booking System!");
    }
}
