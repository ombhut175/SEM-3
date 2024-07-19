
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
        System.out.println("enter number of rows");
        int m = sc.nextInt();
        System.out.println("enter number of columns");
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+"a["+i+"]"+"["+j+"] = "+a[i][j]);
            }
            System.out.println();
        }
        
        Pair a1 = new Pair(a[0][0],a[0][1]);
        Stack <Pair> s = new Stack<>();
        s.push(a1);
        int constJ = 0;
        for(int i=1;i<m;i++){
            
            if(a[i][constJ]>=a[i-1][constJ] && a[i][constJ]<=a[i-1][constJ+1] || a[i][constJ+1]>=a[i-1][constJ] && a[i][constJ+1]<=a[i-1][constJ+1]){
                s.pop();
                if(a[i][constJ]>=a[i-1][constJ] && a[i][constJ+1]>=a[i-1][constJ+1]){
                    s.push(new Pair(a[i-1][constJ],a[i][constJ+1]));  
                }
                else{
                    s.push(new Pair(a[i-1][constJ], a[i-1][constJ+1]));
                }
            }
            else{
                s.push(new Pair(a[i][constJ], a[i][constJ+1]));
            }
        }
        // String s1 = "";
        // while(!s.isEmpty()){
        //     Pair p = s.pop();
        //     System.out.println(p.a+" "+p.b);
        // }
        // System.out.println(s1);
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
