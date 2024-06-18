// . Read n numbers in an array then read two different numbers, replace 1st
// number with 2nd number in an array and print its index and final array.
import java.util.Scanner;
/**
 * Q18
 */
public class Q18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter first number");
        int first=sc.nextInt();
        System.out.println("enter second number");
        int second=sc.nextInt();
        int index1=0,index2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==first){
                index1=i;
            }
            else if(arr[i]==second){
                index2=i;
            }
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        System.out.println("first index = "+index1);
        System.out.println("second index = "+index2);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }
}