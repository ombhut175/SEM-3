import java.util.Scanner;

/**
 * Q1
 */
public class Q38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of stack");
        int n = sc.nextInt();
        MyStack s = new MyStack(n);
        boolean flag=true;
        while (flag) {
            System.out.println("enter 1 for \'push\' 2 for \'pop\' 3 for \'peep\' 4 for \'change\' 5 for \'exit\'");
            int check=sc.nextInt();
            switch (check) {
                case 1: s.push();
                        s.display();
                        break;
                case 2: s.pop();
                        s.display();
                        break;
                case 3: s.peep();
                        s.display();
                        break;
                case 4: s.change();
                        s.display();
                        break;
                case 5: flag=false;
                        break;
            }
        }

    }
}

class MyStack{
    Scanner sc = new Scanner(System.in);
    int n=0;
    int top=-1;
    int[] a;
    public MyStack(int n){
        this.n = n;
        this.a=new int[n];
    }
    public void push(){
        System.out.println("enter new element");
        int x = sc.nextInt();
        if(top>=n-1){
            System.out.println("stack overflow");
            return;
        }
        top=top+1;
        // System.out.println(top);
        a[top]=x;
        // System.out.println(a[top]);
    }
    public int pop(){
        if(top<0){
            System.out.println("Stack underflow");
            return 0;
        }
        top--;
        return a[top+1];
    }
    public int peep(){
        System.out.println("enter value to find");
        int i = sc.nextInt();
        if(top-i<0){
            System.out.println("Stack underflow");
            return 0;
        }
        System.out.println(a[top-i]);
        return a[top-i];
    }
    public void change(){
        System.out.println("enter index");
        int i = sc.nextInt();
        System.out.println("enter new element");
        int x=sc.nextInt();
        if(top-i<0){
            System.out.println("stack underflow");
            return;
        }
        a[top-i]=x;
    }
    public void display(){
        if(top<0){
            System.out.println("stack is empty");
            return;
        }
        for(int i=0;i<=top;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}