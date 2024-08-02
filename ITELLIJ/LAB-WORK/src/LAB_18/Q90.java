package LAB_18;

import java.util.Scanner;

//90. Write a program to implement a Linear Search using Array.
public class Q90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = {3,9,2,5,1,5,2};
        System.out.println("enter number to find");
        int n = sc.nextInt();
        int length = a.length;
        int index=-1;
        for(int i=0;i<length;i++){
            if(n==a[i]){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("element is not present");
        }else{
            System.out.println("element "+n+" is at index "+index);
        }
    }
}
