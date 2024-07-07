

public class Q56 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(9);
        Node e = new Node(6);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        Node temp=a;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
}

/**
 * Node
 */
class Node {
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
    
}