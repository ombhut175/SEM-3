// Create methods to convert temperature from Celsius to Fahrenhit and vice
// versa. Take temperature input from user and call the appropriate conversion
// method

import java.util.Scanner;

/**
 * Q36
 */
public class Q36 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("F for fahrenheit and C for celsius");
        Q36 a = new Q36();
        String s = sc.next();
        s=s.toLowerCase();
        char check = s.charAt(0);
        if(check=='f'){
            System.out.println("enter fahrenheit");
            double f = sc.nextDouble();
            System.out.println(a.cToF(f));
        }
        else{
            System.out.println("enter celsius");
            double c = sc.nextDouble();
            System.out.println(a.fToc(c));
        }
    }
    double cToF(double c){
        double f= (9.0/5)*c+32;
        return f;
    }
    double fToc(double f){
        double c = (5.0/9)*(f-32);
        return c;
    }
}