package LAB_18;

import java.util.Scanner;

public class Q91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = {1,3,7,9,13,15,19};
        System.out.println("enter number to find");
        int s = sc.nextInt();
//        int length = a.length;
        int index=-1;
        int left=0;
        int right=a.length-1;
        while(right>=left){
            int mid = (right+left)/2;
            if(s==a[mid]){
                index=mid;
                break;
            } else if(s>a[mid]){
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        if(index==-1){
            System.out.println("element is not present");
        }else {
            System.out.println("element "+s+" is at index "+index);
        }
    }
}
