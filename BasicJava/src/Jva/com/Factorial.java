package Jva.com;
public class Factorial {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        var product =1;
        var lowerbound = 1;
        var upperbound = 11;
        for (int i=1; i<upperbound ; i++){
            product*=i;
        }
        System.out.println("THe final product of the  from 1 to 11 is "+product);
    }
}
