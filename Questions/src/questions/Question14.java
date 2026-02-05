package questions;

public class Question14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 5; for (int i = 1; i <= rows; i++) { for (int s = rows - i; s > 0; s--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*"); System.out.println(); }

}}
