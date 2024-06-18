// Write a program to find whether the array contains a duplicate number or not.
import java.util.Scanner;
/**
 * Q17
 */
public class Q17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,2,3,2};
        int l = a.length;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(a[i]==a[j]){
                    System.out.println(a[i]);
                }
            }
        }
    }
}