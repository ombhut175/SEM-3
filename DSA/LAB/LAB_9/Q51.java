import java.util.Scanner;

public class Q51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of queue");
        int n = sc.nextInt();
        CircularQueue cq1 = new CircularQueue(n);
        outer:
        while (true) {
            System.out.println("1 insert for 2 for delete ");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                        System.out.println("enter number");
                        int y=sc.nextInt();
                        cq1.insert(y);
                        cq1.display();
                    break;
                case 2:
                        cq1.delete();
                        cq1.display();
                        break;
                default:
                    break outer;
            }
        }
        // cq1.insert(5);
        // cq1.display();
        // cq1.insert(6);
        // cq1.display();
        // cq1.insert(7);
        // cq1.display();

        // cq1.delete();
        // cq1.display();
        // cq1.delete();
        // cq1.display();
        // cq1.delete();
        // cq1.display();
    }
}

class CircularQueue{
    int r=-1;
    int f=-1;
    int[] q;
    int n;
    CircularQueue(int n){
        this.n=n;
        this.q = new int[n];
    }
    void insert(int y){
        if(r>=n-1 && f==0){
            System.out.println("queue overflow");
            return;
        }
        if(r+1==f){
            System.out.println("queue overflow");
            return;
        }
        r=(r+1)%n;
        System.out.println(r);
        q[r] = y;
        if(f<0){
            f=0;
        }
    }
    void delete(){
        if(f<0){
            System.out.println("queue underflow");
            return;
        }
        if(f==r){
            System.out.println("queue underflow");
            f=r=-1;
            return;
        }
        f=(f+1)%n;
    }
    void display(){
        if(f<0){
            System.out.println("queue is empty");
            return;
        }
        int i=f;
        while (i!=r){
            System.out.print(q[i]+" ");
                i=(i+1)%n;
        }
        System.out.print(q[i]);
        System.out.println();
    }
}