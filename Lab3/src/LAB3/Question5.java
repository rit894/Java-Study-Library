package LAB3;
import java.util.Scanner;
import java.util.ArrayList;
public class Question5 {

	public static void main(String[] args) {
		reverseArray();

	}
	public static void reverseArray() {
		Scanner obj= new Scanner(System.in);
		var list1= new ArrayList<Integer>();
		System.out.print("Enter the number of times of ur entering number: ");
		int num = obj.nextInt();
		obj.nextLine();
		for (int i=0;i<num;i++) {
			int num1 = obj.nextInt();
			obj.nextLine();
			list1.add(num1);
			
		}
		var list2 =new ArrayList<Integer>();
		for (int j = list1.size() - 1; j >= 0; j--) {
		    int temp = list1.get(j);
		    System.out.println(temp);
		    list2.add(temp);
		}

		System.out.println(list2);
	} 

}
