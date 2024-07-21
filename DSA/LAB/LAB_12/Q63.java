// package DSA.LINKED LIST;

import java.util.Scanner;

public class Q63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CopyLinkList l1 = new CopyLinkList();
        CopyLinkList l2 = new CopyLinkList();
        outer:
        while (true) {
            System.out.println("enter 1 for last add 2 for exit");
            int check=sc.nextInt();
            switch (check) {
                case 1:
                    System.out.println("enter number");
                    int n = sc.nextInt();
                    l1.addLast(n);
                    l1.display();
                    break;
                case 2: break outer;
            }
        }
        l2.copy(l1);
        l2.addLast(200); //checking
        l2.display();

    
        sc.close();
    }
}
class CopyLinkList{
    Node first;
    Node last;
        void addLast(int x){
            Node newNode = new Node(x);
            if(first==null){
                first=newNode;
                last=newNode;
                return;
            }
            last.link=newNode;
            last=newNode;
        }
        void copy(CopyLinkList l1){
           
            if(l1.first==null){
                System.out.println("list is empty");
                return;
            }
           this.first=new Node(l1.first.info);
           Node temp = this.first;
           Node save=l1.first;
           save=save.link;
           Node pred;
           while(save!=null){
                pred=temp;
                Node newNode=new Node(save.info);
                save=save.link;
                pred.link=newNode;
                temp=temp.link;
           }
           this.last=temp;
        }
        void display(){
            Node save=first;
            while (save!=null) {
                System.out.print(save.info+" ");
                save=save.link;
            }
            System.out.println();
        }
        void checkCopy(CopyLinkList l1){
            Node save1 = this.first;

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