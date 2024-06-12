import java.util.Scanner;
public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n=sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++){
            sum += i;
        }
        double avg = (double)sum/n;
        System.out.println(avg);
    }
}
