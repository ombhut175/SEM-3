import java.util.Scanner;

/**
 * Q29(2)
 */
public class Q29_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of test cases");
        int tc = sc.nextInt();
        System.out.println("enter size of array");
        int n = sc.nextInt();
        System.out.println("enter array");
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int b[] = new int[n];
        int c[] = new int[n];
        for(int i=0;i<n;i++){
            b[i] = a[i];
        }


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(b[i]>b[j]){

                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                    // System.out.print(b[i]+" ");
                }
            }
        }
        int cIndex = 0;
        for(int i=b.length-1;i>=0;i--){
            c[cIndex] = b[i];
            cIndex++;
            if(cIndex==b.length){
                break;
            }
        }
        int[] d = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(b[i]==a[j]){
                    d[i]=c[j];
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(d[i]+" ");
        }
    }
    
}
