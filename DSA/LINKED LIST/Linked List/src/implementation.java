
public class implementation {
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next=null;
		}
	}
	public static class LinkedList{
		Node head = null;
		Node tail = null;
		void insertAtEnd(int data) {
			Node temp = new Node(data);
//			System.out.println("temp = "+temp);
			
			if(head==null) {
				head = temp;
//				System.out.println("head = "+head);
				
			}
			else {
				tail.next=temp;
//				System.out.println("tail.next = "+temp);
			}
			tail=temp;
//			System.out.println("tail = "+tail);
//			System.out.println("head 2 = "+head);
		}
		void insertAtStart(int value) {
			Node temp = new Node(value);
			if(head==null) {
				insertAtEnd(value);
			}
			else {
				temp.next=head;
				head = temp;;
			}
				}
		void display() {
			Node temp = head;
			while (temp!=null) { 
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(10);
		ll.display();
		ll.insertAtEnd(50);
		ll.display();
		ll.insertAtEnd(80);
		ll.display();
		ll.insertAtStart(5);
		ll.display();
	}
}
