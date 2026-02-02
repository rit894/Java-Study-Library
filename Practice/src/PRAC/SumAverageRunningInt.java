package PRAC;

public class SumAverageRunningInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var num1=0.0d;
		var lowerbound=0;
		var upperbound = 100 ;
		
	for(int i =0;i<=upperbound;i++) {
	 num1+=i;	
	} 
	System.out.println("the sum of these nubers is "+num1);
	System.out.println("this is the average of those numbers "+num1/upperbound);

}
}