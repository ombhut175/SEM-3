import java.util.Scanner;

public class Q57 {
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
		if(middNode.data<head.data){
			middNode.next=head;
			head=middNode;
			return;
		}
		Node temp=middNode;
		Node temp2=head ;
		Node pre=null;
		while(temp2!=null && temp.data>temp2.data){
			pre=temp2;
			temp2=temp2.next;
		}
		if(temp2==null){
			pre.next=temp;
		}
		else{
			pre.next=temp;
			temp.next=temp2;
		}
	}
	public static void delete(Node x){
		if(head==null){
			System.out.println("underflow");
			return;
		}
		Node save=head;
		Node pre = null;
		
		while(save!=x && save!=null){
			pre=save;
			save=save.next;
		}
		if(save!=x){
			System.out.println("node not found");
			return;
		}
		if(save==head){
			head=head.next;
		}
		else{
			pre.next=x.next;
		}
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
			System.out.println("1 for \"insertAtFirst\" 2 for \"last\" 3 for \"insord\" 4 for \"delete\" 5 for \"exit\"");
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
				if(head==null){
					System.out.println("list is empty");
					break;
				}
					System.out.println("enter node to delete");
					int delete=sc.nextInt();
					Node temp=head;
					while (temp!=null && delete!=temp.data) {
						temp=temp.next;
					}
					if(temp==null){
						System.out.println("node not found");
						break;
					}
					delete(temp);
					display();
					break;
				case 5:
					flag=false;
					break;
			}
		}
	}
}
