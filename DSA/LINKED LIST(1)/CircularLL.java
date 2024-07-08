import java.util.Scanner;
public class CircularLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cl1 = new CircularLinkedList();
        outer:
        while (true) {
            System.out.println("1 for \"insertAtFirst\" 2 for \"last\" 3 for \"insord\" 4 for \"delete\" 5 for \"exit\"");
            int check = sc.nextInt();
            switch (check) {
                case 1: System.out.println("enter value");
                        int x = sc.nextInt();
                        cl1.addFirst(x);
                        break;
                case 5: break outer;
            }
        }
    }    
}
class CircularLinkedList{
    Node head;
    Node tail;
    public void addFirst(int x){
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
            tail=newNode;
            newNode.next=head;
            return;
        }
        newNode.next=head;
        tail.next=newNode;
        head=newNode;
    }
    public void display(){
        Node temp=head;
        do{
            System.out.println(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
    }
}
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}