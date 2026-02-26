package PRAC;
import java.util.Scanner;

public class EvalQ {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter a Number: ");
		int n = obj.nextInt();
		obj.nextLine();
		for(int i = 1; i<=n; i++) {
			
			for (int j=1 ; j<=n-i;j++){
				System.out.print(" ");
				}
			
			for (int k=1;k<=i;k++) {
				
				System.out.print(k);
				
			}
			for (int l= i-1;l>=1;l--) {
				System.out.print(l);
			}System.out.println();
		}
			
			
		for (int a=n-1 ; a>=1 ; a--) {
		
			for (int j=1 ; j<=n-a;j++){
				System.out.print(" ");
				}
			
			for (int k=1;k<=a;k++) {
				
				System.out.print(k);
				
			}
			for (int l= a-1;l>=1;l--) {
				System.out.print(l);
			}System.out.println();
			
		
		}

	}}



