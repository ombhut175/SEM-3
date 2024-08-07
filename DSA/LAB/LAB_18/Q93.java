
import java.util.Scanner;

/**
 * Q93
 */
public class Q93 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {12,6,3,5,2};
        int i=1;
        while(i<a.length){
            int j=i-1;
            int key = a[i];
            while(j>=0 && a[j]>key){
                a[j+1]=a[j];
                j=j-1;
            }
            a[j+1]=key;
            i++;
        }
        for(int j=0;j<a.length;j++){
            System.out.print(a[j]+" ");
        }
    }
}