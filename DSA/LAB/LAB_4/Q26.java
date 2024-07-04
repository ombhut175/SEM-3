import java.util.Scanner;

public class Q26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,3,4,2,5,6};
        int b[]={5,9,3,2};
        int c[] = new int[a.length+b.length];
        for(int i=0;i<a.length;i++){
            c[i]=a[i];
        }
        for(int i=a.length;i<c.length;i++){
            c[i]=b[i-a.length];
            // System.out.println(c);
        }
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]+" ");
        }
    }
}
