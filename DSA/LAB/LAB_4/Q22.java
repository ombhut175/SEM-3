import java.util.Scanner;

// package DSA.LAB.LAB_4;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter index to remove element");
        int removeIndex = sc.nextInt();
        for(int i=removeIndex;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        n--;
        for(int i=0;i<n;i++){
            System.out.println("array at index "+i);
            System.out.println(arr[i]);
        }
}
}
