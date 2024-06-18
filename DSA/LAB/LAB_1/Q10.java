// . WAP to convert number of days into year, week & days [e.g. 375 days mean 1 year, 1 week and 3 days]
/**
 * Q10
 */
import java.util.Scanner;
public class Q10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter days");
        int n= sc.nextInt();
        int year = n/365;
        int remainingYear = n-(365*year);
        int week = remainingYear / 7;
        int day = remainingYear - (7*week);
        System.out.println(year + " year, "+week+" week, "+day+" days");
    }
}
