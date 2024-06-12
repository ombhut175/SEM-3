import java.util.Scanner;

public class Q6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of x");
        int x = sc.nextInt();
        System.out.println("enter value of y");
        int y = sc.nextInt();
        int ans =1;
        for(int i=1;i<=y;i++){
            ans = ans*x;
        }
        System.out.println("ans = "+ans);
    }
}