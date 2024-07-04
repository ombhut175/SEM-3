// Write a program to delete a number from an array that is already sorted in an
// ascending order.
/**
 * Q24
 */
import java.util.Scanner;
public class Q24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,4,8,11,12};
        int remove = 11;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if(remove==a[i]){
                index=i;
                break;
            }
        }
        for (int i = index; i < (a.length)-1; i++) {
            a[i] = a[i+1];
        }
        for (int i = 0; i < (a.length)-1; i++) {
            System.out.print(a[i]+" ");
        }
    }
}