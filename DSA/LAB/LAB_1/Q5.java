import java.util.Scanner;
public class Q5 {
    public static void main(String[] args){
	   Scanner sc = new Scanner(System.in);
	   System.out.println("enter number");
	   int n = sc.nextInt();
	   int result = factorial(n);
	   System.out.println(result);
	}
     static int factorial(int n){
	if(n==1){
	return 1;
	}
	else{
	return n*factorial(n-1);
		}
	}
}
