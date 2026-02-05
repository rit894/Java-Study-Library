package questions;

public class Question15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 4; for (int i = 1; i <= rows; i++) { for (int s = rows - i; s > 0; s--) System.out.print(" "); for (int j = 1; j <= i; j++) System.out.print(i); System.out.println(); }
	}

}
