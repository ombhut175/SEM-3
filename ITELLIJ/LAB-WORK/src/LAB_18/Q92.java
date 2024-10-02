// package LAB_18;

import java.util.Scanner;

public class Q92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {5,2,9,16,12,11};
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                   if(a[j]>a[j+1]){
                       int temp = a[j];
                       a[j]=a[j+1];
                       a[j+1]=temp;
                   }
            }
            
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
