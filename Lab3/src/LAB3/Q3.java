package LAB3;
import java.util.Scanner;
import java.util.ArrayList;
public class Q3 {

	public static void main(String[] args) {
		
		sumEvenNumbers();
	}
public static void sumEvenNumbers() {
	Scanner obj= new Scanner(System.in);
	var list1= new ArrayList<Integer>();
	System.out.print("ENter the number of times of ur entering number: ");
	int num = obj.nextInt();
	obj.nextLine();
	
	for (int i =0;i<num;i++) {
		System.out.print("ENter the number of times of ur entering number: ");
		int num1 = obj.nextInt();
		obj.nextLine();
		list1.add(num1);
		
	}
	System.out.println(list1);
	int sum=0;
	
	for(int i:list1) {
		if(i%2==0) {
		sum+=i;}
		
	}System.out.println(sum);
}

}
