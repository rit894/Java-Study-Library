package LAB3;
import java.util.Scanner;
public class q2 {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		System.out.print(" Enter a year");
		int year= obj.nextInt();
		isLeapYear(year);

	}
	public static void isLeapYear(int year) {
		if ((year%4==0 && year%100!=0)|| year %400==0) {
			System.out.println("This year is a leap year!!");
			
		} else {
			System.out.println("not leap year!!");
		}
	}

}
