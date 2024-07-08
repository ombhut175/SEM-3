public class Q1 {
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }   
    }
    static void display(Node head){
        while(head!=null){
            System.out.print(head.data + " "); // Use print instead of println
            head = head.next;
        }
    }
    static int length1(Node head){
        int count=0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
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
        display(a);
        System.out.println("length = "+length1(a));
    }
}
