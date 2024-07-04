// Read two 2x2 matrices and perform addition of matrices into third matrix and
// print it
/**
 * Q1
 */
import java.util.Scanner;
public class Q31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows");
        int m = sc.nextInt();
        System.out.println("enter number of columns");
        int n = sc.nextInt();
        int [][] a = new int[m][n];
        System.out.println("enter elements of first array");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        int [][] b = new int[m][n];
        System.out.println("enter elements of second array");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                b[i][j] = sc.nextInt();
            }
        }
        int [][] c = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
