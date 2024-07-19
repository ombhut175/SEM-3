public class CopyOfNode {
    public static void main(String[] args) {
        // Node a = new Node(10);
        // Node b = new Node(20);
        // Node c = new Node(30);
        // Node d = new Node(40);
        // a.next=b;
        // b.next=c;
        // c.next=d;
        // NewNode nn = new NewNode();
        // Node hNewNode = nn.copy(a);
        CopyLinkedList l1 = new CopyLinkedList();
        CopyLinkedList l2 = new CopyLinkedList();
        CopyLinkedList revLinkedList = new CopyLinkedList();
        for (int i = 1; i <= 10; i++) {
            l1.addLast(i);
        }
        l1.display();
        l2.copyNewNode(l1);
        // l2.addLast(11); // checking
        // l2.reverse();
        l2.display();
        // CopyLinkedList.display();
        // l1.reverseNode(l2);
        // l2.display();
        l2.checkCopy(l1);
    }       
}
class CopyLinkedList{
     Node head;
     Node tail;
    // public void getHeadAndTail(Node head,Node tail){
    //     this.head=head;
    //     this.tail=tail;
    // }

    public void addLast(int x){
        Node newNode=new Node(x);
        if(head==null){
            head = newNode;
            tail=newNode;
            return;
        }
        // Node temp=head;
        tail.next=newNode;
        tail=newNode;
    }
    public void addFirst(int x){
        Node newNode = new Node(x);
        if (head==null) {
            head=newNode;
            tail=newNode;
            return;          
        }
        newNode.next=head;
        head=newNode;
    }
    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void reverseNode(CopyLinkedList l2){
        if(this.head==null){
            System.out.println("list is empty");
            return;
        }
        Node temp=this.head;
        while(temp!=null){
            l2.addFirst(temp.data);
            temp=temp.next;
        }

    }
    public void copyNewNode(CopyLinkedList l1){
        if(l1.head==null){
            System.out.println("list is empty");
            return;
        }
        Node first=l1.head;
        while (first!=null) {
            addLast(first.data);
            first=first.next;
        }
    }
    public void reverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        Node prev=null;
        Node current=head;
        Node next=null;
        tail=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    void checkCopy(CopyLinkedList l1){
        Node save1 = this.head;
        Node save2 = l1.head;
        int count1=0,count2=0;
        while(save1!=null){
            count1++;
            save1=save1.next;
        }
        while (save2!=null) {
            count2++;
            save2=save2.next;
        }
        if(count1!=count2){
            System.out.println("both ll are not same");
            return;
        }
        save1=this.head;
        save2=l1.head;
        int count=0;
        while (save1!=null) {
            if(save1.data==save2.data){
                count++;
            }
            save1=save1.next;
            save2=save2.next;
        }
        if(count==count1){
            System.out.println("both ll are same");
        }
        else{
            System.out.println("both ll are not same");
        }
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