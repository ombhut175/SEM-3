import java.util.Scanner;
public class Q50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of queue");
        int n = sc.nextInt();
        QueueImplementation s1 = new QueueImplementation(n);
        outer:
        while (true) {
            System.out.println("1 for queue 2 for deque");
            int check = sc.nextInt();
            switch (check) {
                case 1: System.out.println("enter number");
                        int x = sc.nextInt();
                        s1.enque(x);
                        s1.display();
                    break;
                case 2: s1.deque();
                        s1.display();
                    break;
                default:
                    break outer;
            }
        }
    }
}
class QueueImplementation{
    int r=-1;
    int f=-1;
    int[] a ;
    int n;
    public QueueImplementation(int n){
        this.n=n;
        this.a=new int[n];
    }
    public void enque(int x){
        if(r>=n-1){
            System.out.println("queue overflow");
            return;
        }
        r++;
        a[r]=x;
        if(f<0){
            f++;
        }
    }
    public void deque(){
        if(r<0){
            System.out.println("queue underflow");
            return;
        }
        if(f>=r){
            f=-1;
            r=-1;
        }
        f++;
    }
    public void display(){
        // int temp=f;
        for(int i=f;i<=r;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}