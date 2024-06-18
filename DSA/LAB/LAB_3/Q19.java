// WAP to print Pascal triangle.
/**
 * Q19
 */
import java.util.Scanner;
public class Q19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of n");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int k=n-1;k>=i;k--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}