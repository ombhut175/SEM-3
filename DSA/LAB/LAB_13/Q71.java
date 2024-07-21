import java.util.Scanner;
public class Q71 {
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
                        cl1.display();
                        break;
                case 2: System.out.println("enter value");
                        x = sc.nextInt();
                        cl1.addLast(x);
                        cl1.display();
                        break;
                case 3: System.out.println("enter value");
                        x = sc.nextInt();
                        cl1.insord(x);
                        cl1.display();
                        break;
                case 4:System.out.println("enter element to delete");
                        x=sc.nextInt();
                        cl1.delete(x);
                        cl1.display();
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
    public void addLast(int x){
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
            tail=newNode;
            newNode.next=head;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        newNode.next=head;
    }
    public void insord(int x){
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
            tail=newNode;
            newNode.next=head;
            return;
        }
        if(newNode.data<head.data){
            addFirst(x);
            return;
        }
        Node prev=null;
        Node temp=head;
        do {
            prev=temp;
            temp=temp.next;
        } while (temp!=head && temp.data<newNode.data);
        if(temp==head){
            prev.next=newNode;
            tail=newNode;
            newNode.next=head;
            
        }
        else{
            prev.next=newNode;
            newNode.next=temp;
        }
    }
    public void delete(int x){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(head.data==x){
            head=head.next;
            tail.next=head;
            return;
        }
        Node temp=head;
        Node prev=null;
        do{
            prev=temp;
            temp=temp.next;
        }while(temp!=head && temp.data!=x);
        if (temp==head) {
            System.out.println("element not present");
            // return;
        } else{
            if(temp.next==head){
                tail=prev;
            }
            prev.next=temp.next;
        }
    }
    
    public void display(){
        Node temp=head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
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