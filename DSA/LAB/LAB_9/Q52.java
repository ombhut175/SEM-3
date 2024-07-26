import java.util.Scanner;

public class Q52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of queue");
        int n = sc.nextInt();
        DoubleEndedLL dbl1 = new DoubleEndedLL(n);
        outer:
        while (true) {
            System.out.println("1 for insert at last 2 for delete first 3 for insert first 4 for delete last");
            int check = sc .nextInt();
            switch (check) {
                case 1:
                    System.out.println("enter number");
                    n = sc.nextInt();
                    dbl1.insertLast(n);
                    dbl1.display();
                    break;
                case 2:
                    dbl1.deleteFirst();
                    dbl1.display();
                    break;
                case 3:
                    System.out.println("enter number");
                    n = sc.nextInt();
                    dbl1.insertFirst(n);
                    dbl1.display();
                    break;
                case 4:
                    dbl1.deleteLast();
                    dbl1.display();
                    break;
                default:
                    break outer;
            }
        }
    }
}


class DoubleEndedLL{
    int f=-1;
    int r=-1;
    int[] q;
    int n;
    DoubleEndedLL(int n){
        this.n=n;
        this.q=new int[n];
    }
    void insertLast(int x){
        if(r>=n-1){
            System.out.println("queue overflow");
            return;
        }
        r++;
        q[r]=x;
        if(f==-1){
            f=0;
        }
    }
    void deleteFirst(){
        if(f==-1){
            System.out.println("queue underflow");
            return;
        }
        if(f==r){
            f=-1;
            r=-1;
            return;
        }
        f++;
    }
    void insertFirst(int x){
        if(f==0){
            System.out.println("queue is full");
            return;
        }
        if(f==-1){
            f=0;
            r=0;
        }
        else{
            f--;
        }
        q[f]=x;
    }
    void deleteLast(){
        if(r==-1){
            System.out.println("queue underflow");
            return;
        }
        if(r==f){
            r=-1;
            f=-1;
            return;
        }
        r--;
    }
    void display(){
        if(f==-1){
            System.out.println("queue is empty");
            return;
        }
        for(int i=f;i<=r;i++){
            System.out.print(q[i]+" ");
        }
        System.out.println();
    }
}