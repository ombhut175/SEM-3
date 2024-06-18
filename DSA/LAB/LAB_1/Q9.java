// WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS
// [e.g. 10000 seconds mean 2:46:40 (2 Hours, 46 Minutes, 40 Seconds)].
import java.util.Scanner;
/**
 * Q9
 */
public class Q9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter seconds");
        int n = sc.nextInt();
        int hour = n/3600;
        int remainingHour = n-(3600*hour);
        int minute = remainingHour/60;
        int second = remainingHour-(60*minute);
        System.out.println(hour+" : "+minute+" : "+second);
    }
}