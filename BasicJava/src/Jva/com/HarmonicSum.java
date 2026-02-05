package Jva.com;
public class HarmonicSum {
public static void main(String[] args) {
    int max_denominator=20;
    double harmonic_sum2=0.0;
    double harmonic_sum1=0.00d;
    for (int i=1;i<=max_denominator;i++){
        harmonic_sum1+= 1.0/i;
    }System.out.println("Harmonic Sum 1"+harmonic_sum1);
    for (int j=max_denominator ; j>=1;j-- ){
        if (j==0){
            break;}
            else{
        
        harmonic_sum2+=1.0/j;}
    }System.out.println("Harmonic Sum2 "+harmonic_sum2);
    if (harmonic_sum1!=harmonic_sum2){
        System.out.println("The Computer has low precssionn and accuracy ");
    }else{
        System.out.println("THe Computer is perfectly fine");
    }
} 
}
