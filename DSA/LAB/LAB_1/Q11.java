// WAP to find the sum of 1 + (1+2) + (1+2+3) + (1+2+3+4)+ …+(1+2+3+4+….+n).
import java.util.Scanner;
/**
 * Q11
 */
public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        int sum = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                sum = sum+j;
            }
        }
        System.out.println(sum);
    }
    
}