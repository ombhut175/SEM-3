// package classWork;
import java.util.Scanner;

public class insertOperationCorrect {
	static Node head;
	static Node tail;
	static Scanner sc = new Scanner(System.in);
	public static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public static void insertAtFirst(int x) {
		Node n = new Node(x);
		if(head==null) {
			head=n;
			tail=n;	
			return;		
		}
		n.next=head;
		head=n;
		// head=first;

	}
	public static void insertAtLast(int x){
		if(head==null){
			insertAtFirst(x);
			return;
		}
		Node last = new Node(x);
		tail=head;
		while (tail.next!=null) {
			tail=tail.next;
		}
		tail.next=last;
		tail=last;

	}
	public static void insord(int x){
		Node middNode = new Node(x);
		if(head==null){
			head=middNode;
			tail=middNode;
			return;
		}
		Node temp=middNode;
		// System.out.println("temp.data = "+temp.data);
		Node temp2=head ;
		while(temp.data>temp2.next.data && temp2.next!=null){
			// System.out.println("temp 2.data = "+temp2.data);
			temp2=temp2.next;
		}
		temp.next=temp2.next;
		temp2.next=temp;
		// System.out.println("temp.next "+temp.data+" temp2.next "+temp2.data);
		// System.out.println("temp2.next "+temp2.data+" temp = "+temp.data);
		
	}
	public static void display() {
		// System.out.println("loop entered display");
		int count=0;
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
			count++;
		}
		System.out.println();
		System.out.println("count = "+count);
		System.out.println();
	}
	public static void main(String[] args) {

		// Node headNode = insert(50, null);
        // Node a = new Node(60);
		// head=a;
		// Node b = new Node(70);
		// Node c = new Node(80);
		// Node d = new Node(90);
		// tail=d;
		// a.next=b;
		// b.next=c;
		// c.next=d;
		// Node insertFirst = insertAtFirst(50);
        // display();
		// Node insertLast=insertAtLast(170);
		// display();
		// Node insertMiddle=insord(75);
		// display()
		boolean flag=true;
		while (flag) {
			System.out.println("1 for \"insertAtFirst\" 2 for \"last\" 3 for \"insord\" 4 for \"exit\"");
            int check = sc.nextInt();
			switch (check) {
				case 1:
					System.out.println("enter first element");
					int first=sc.nextInt();
					insertAtFirst(first);
					display();
					break;
				case 2:
					System.out.println("enter last element");
					int last=sc.nextInt();
					insertAtLast(last);
					display();
					break;
				case 3:
					System.out.println("enter number");
					int midd=sc.nextInt();
					insord(midd);
					display();
					break;
				case 4:
					flag=false;
					break;
			}
		}
		
		
	}
}
