// 67. WAP to perform given operation in the linked list. There exist a Linked List. Add a node
// that contains the GCD of that two nodes between every pair adjacent node of Linked
// List

import java.util.Scanner;

/**
 * Q67
 */
public class Q67 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GCD gcd1 = new GCD();
        outer:
        while (true) {
            System.out.println("1 for insert 2 for gcd");
            int check=sc.nextInt();
            switch (check) {
                case 1:
                    System.out.println("enter number");
                    int x = sc.nextInt();
                    gcd1.addLast(x);
                    gcd1.display();
                    break;
                case 2:
                    gcd1.gcd();
                    gcd1.display();
                    break;
                default:
                    break outer;
            }
        }
    }
}
class GCD{
    Node first;
    Node last;
    public void addLast(int x){
        Node newNode = new Node(x);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        Node save=first;
        while(save.link!=null){
            save=save.link;
        }
        save.link=newNode;
        last=newNode;
    }

    public void gcd(){
        if(first==null || first==last){
            System.out.println("invalid LL");
            return;
        }
        Node save=first;
        Node save2 = save.link;
        while(save2!=null){
            int a = save.info;
            int b = save2.info;
            int gcd=1;
            for(int i=1;i<=a && i<=b;i++){
                if(a%i==0 && b%i==0){
                    gcd=i;
                }
            }
            Node newNode = new Node(gcd);
            save.link=newNode;
            newNode.link=save2;
            save=save.link.link;
            save2=save2.link;
        }
    }
    void display(){
        Node save=first;
        while (save!=null) {
            System.out.print(save.info+" ");
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