
import java.util.Scanner;

public class Q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements of array");
        for (int i = 0; i < n; i++) {
            // System.out.println("enter element number "+(i+1));
            arr[i] = sc.nextInt();
        }
        System.out.println("enter new index");
        int newIndex = sc.nextInt();
        System.out.println("enter new element");
        int insert = sc.nextInt();
        int[] brr = new int[n+1];
        for(int i=0;i<newIndex;i++){
            brr[i] = arr[i];
        }
        brr[newIndex] = insert;
        for(int i=newIndex;i<(brr.length)-1;i++){
            brr[i+1]=arr[i]; 
        }
        for(int i=0;i<(brr.length);i++){
            System.out.println(brr[i]+" ");
        }
    }
}
