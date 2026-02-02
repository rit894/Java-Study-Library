package PRAC;

public class PrintDayInWord {

	public static void main(String[] args) {
		var number = 2;
		if (number==0) {
			System.out.println("Sunday");
		}
		else if (number==1) {
			System.out.println("Monday");
		}else if (number==2) {
			System.out.println("Tuesday");
		}else if (number==3) {
			System.out.println("Wednesday");
		}else if (number==4) {
			System.out.println("Thursday");
		}else if (number==5) {
			System.out.println("Friday");
		}else if (number==6) {
			System.out.println("satday");
		}else {
			System.out.println("INVALID DAY");
		}
	}

}
