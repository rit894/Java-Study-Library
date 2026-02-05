package questions;

public class Question19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 5; for (int i = 0; i < rows; i++) { for (int s = rows - i; s > 0; s--) System.out.print(" "); int num = 1; for (int j = 0; j <= i; j++) { System.out.print(num + " "); num = num * (i - j) / (j + 1); } System.out.println(); }
	}

}
