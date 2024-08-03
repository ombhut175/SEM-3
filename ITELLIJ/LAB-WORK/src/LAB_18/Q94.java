package LAB_18;

import java.util.Scanner;

public class Q94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {5,2,9,16,12,11};
        for (int i = 0; i < a.length-1; i++) {
            boolean check=false;
            int minIndex=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[minIndex]){
                    minIndex=j;
                    check=true;
                }
            }
                if(check){
                    int temp = a[i];
                    a[i]=a[minIndex];
                    a[minIndex]=temp;
                }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
