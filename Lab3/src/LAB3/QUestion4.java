package LAB3;
import java.util.Scanner;
import java.util.ArrayList;
public class QUestion4 {

	public static void main(String[] args) {
		System.out.println(findFactorial());
	}
	public static int findFactorial() {
		
		Scanner obj= new Scanner(System.in);
		var list1= new ArrayList<Integer>();
		System.out.println("Enter a number for actorial multiplication: ");
		int number= obj.nextInt();
		int num1=1;
		for (int i = 1;i<=number;i++) {
			num1*=i;
		}
		return num1;
		
		
		
		
		
		
		
		
		
	}

}
