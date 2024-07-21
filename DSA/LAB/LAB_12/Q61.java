import java.util.Scanner;

/**
 * Q61
 */
public class Q61 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingLL ql1 = new QueueUsingLL();
        while (true) {
            System.out.println("1 for enque 2 for dequeue");
            int check=sc.nextInt();
            switch (check) {
                case 1: System.out.println("enter number");
                        int x = sc.nextInt();
                        ql1.enqueue(x);
                        ql1.display();
                        break;
                case 2: ql1.dequeue();
                        ql1.display();
                default:
                    break;
            }
        }
    }
}

class QueueUsingLL{
    Node first;
    Node last;
    void enqueue(int x){
        Node newNode = new Node(x);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        Node save = first;
        while (save.link!=null) {
            save=save.link;
        }
        save.link=newNode;
        newNode=last;
    }
    void dequeue(){
        if(first==null){
            System.out.println("queue underflow");
            return;
        }
        first=first.link;
    }
    void display(){
        Node save = first;
        while(save!=null){
            System.out.print(save.info +" ");
            save=save.link;
        }
        System.out.println();
    }
}

class Node {
    int info;
    Node link;
    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}