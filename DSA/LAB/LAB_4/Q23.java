// Write a program to insert a number in an array that is already sorted in an
// ascending order
/**
 * Q23
 */
import java.util.Scanner;
public class Q23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,4,8,11};
        int l=a.length;
        int insert = 9;
        int index = 0;
        for(int i=0;i<l;i++){
            if(a[i]>insert){
                index=i;
                break;
            }
        }
        int[] b = new int[l+1];
        for(int i=0;i<index;i++){
            b[i]=a[i];
        }
        b[index]=insert;
        for(int i=index;i<(b.length)-1;i++){
            b[i+1] = a[i];
        }
        for(int i=0;i<(b.length);i++){
            System.out.print(b[i]+" ");
       }
    }
}