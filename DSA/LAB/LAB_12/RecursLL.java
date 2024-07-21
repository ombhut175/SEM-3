public class RecursLL {
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }   
    }
    static void displayr(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.data+" ");
        displayr(head.next);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(9);
        Node e = new Node(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        displayr(a);
    }
}
