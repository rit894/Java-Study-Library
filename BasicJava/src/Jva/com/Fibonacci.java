package Jva.com;

public class Fibonacci {
public static void main(String[] args) {
    int n=10;
    int a=0;
    int b=1;
    System.out.print("Fibonacci Series upto "+n+" terms: ");
    for (int i=1;i<=n;i++){
        System.out.print(a+" ");
        int nextterm=a+b;
        a=b;
        b=nextterm;
    }
}
}
