package questions;

public class Question20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 3; for (int i = 1; i <= rows; i++) { for (int j = 0; j < i; j++) System.out.print((char)('A' + j)); for (int j = i - 2; j >= 0; j--) System.out.print((char)('A' + j)); System.out.println(); }
	}

}
