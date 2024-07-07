public class Q58 {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=a;
        CircularLinkedList cll = new CircularLinkedList();
        cll.getHead(a);
        cll.display();
    }
}
class CircularLinkedList{
    static Node head;
    // static Node tail;
    
    public void getHead(Node head){
        this.head=head;
        // this.tail=tail;
    }
    public void display(){
        Node first=head;
        Node pre=null;
        while(first!=null){
            // pre=first;
            // System.out.println(pre.data+" ");
            System.out.println(first + " ");
            first=first.next;
        }
    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}