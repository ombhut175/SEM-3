import java.util.Scanner;
public class Q7 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value");
        int n = sc.nextInt();

        for(int i=2;i<n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
   } 
}
