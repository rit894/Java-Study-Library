package Jva.com;

public class ExtractDigits {
    public static void main(String[] args) {
        int number=12548;
        String num="";
        while(number>0){
            int digit =number%10;
            System.out.println(digit);
            num+=digit+" ";
            
            number=number/10;


        }System.out.println(num);
    }

}
