
import java.util.Scanner;
import java.util.Stack;

public class Q43 {

    public static class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("enter number of rows");
        // int m = sc.nextInt();
        // System.out.println("enter number of columns");
        // int n = sc.nextInt();
        // int a[][] = new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         a[i][j]=sc.nextInt();
        //     }
        // }
        int[][] a = {
            {6,8},
            {1,9},
            {2,4},
            {4,7}
        };
        int m = 4;
        int n = 2;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(a[i][0]>a[j][0]){
                    for(int k=0;k<2;k++){
                        int temp = a[i][k];
                        a[i][k]=a[j][k];
                        a[j][k]=temp;
                    }
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(" "+"a["+i+"]"+"["+j+"] = "+a[i][j]);
        //     }
        //     System.out.println();
        // }
        int constJ = 0;
        Pair a1 = new Pair(a[0][constJ],a[0][constJ+1]);
        Stack <Pair> s = new Stack<>();
        s.push(a1);
        for(int i=1;i<m;i++){
            System.out.println("for i = "+i);
            int p1=s.peek().a;
            int p2=s.peek().b;
            System.out.println("p1 = "+p1);
            System.out.println("p2 = "+p2);
            if(a[i][constJ]>=p1 && a[i][constJ]<=p2 || a[i][constJ+1]>=p1 && a[i][constJ+1]<=p2){
                s.pop();
                if(a[i][constJ]>=p1 && a[i][constJ+1]>=p2){
                    s.push(new Pair(p1,a[i][constJ+1]));  
                }
                else{
                    s.push(new Pair(p1, p2));
                }
            }
            else{
                s.push(new Pair(a[i][constJ], a[i][constJ+1]));
            }
        }
        Stack<Pair> reversedStack = new Stack<>();
        while(!s.isEmpty()) {
            reversedStack.push(s.pop());
        }

        // Print the reversed stack
        while(!reversedStack.isEmpty()) {
            Pair p = reversedStack.pop();
            System.out.println(p.a + " " + p.b);
        }
    }
}
