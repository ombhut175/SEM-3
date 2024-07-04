class insertOperation {
	static Node head;
	static Node tail;
	public static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public static Node insertAtFirst(int x) {
		Node n = new Node(x);
		if(head==null) {
			return n;
		}
		n.next=head;
		head=n;
		// head=first;
		return head;
	}
	public static Node insertAtLast(int x){
		Node last = new Node(x);
		if(head==null){
			return last;
		}
		tail=head;
		while (tail.next!=null) {
			tail=tail.next;
		}
		tail.next=last;
		tail=last;
		return head;
	}
	public static Node insord(int x){
		Node middNode = new Node(x);
		if(head==null){
			return middNode;
		}
		Node temp=middNode;
		// System.out.println("temp.data = "+temp.data);
		Node temp2=head.next;
		while(temp.data>temp2.data && temp2.next!=null){
			// System.out.println("temp 2.data = "+temp2.data);
			temp2=temp2.next;
		}
		temp.next=temp2.next;
		temp2.next=temp;
		// System.out.println("temp.next "+temp.data+" temp2.next "+temp2.data);
		// System.out.println("temp2.next "+temp2.data+" temp = "+temp.data);
		return head;
	}
	public static void display(Node head) {
		int count=0;
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
			count++;
		}
		System.out.println("count = "+count);
		System.out.println();
	}
	public static void main(String[] args) {
		// Node headNode = insert(50, null);
        Node a = new Node(60);
		head=a;
		Node b = new Node(70);
		Node c = new Node(80);
		Node d = new Node(90);
		tail=d;
		a.next=b;
		b.next=c;
		c.next=d;
		Node insertFirst = insertAtFirst(50);
        display(head);
		Node insertLast=insertAtLast(170);
		display(head);
		Node insertMiddle=insord(75);
		display(head);
	}
}
