
import java.util.Scanner;

public class CircularLinedList {

    class Node {

        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;
    public Node last = null;

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
        } else {
            newNode.link = first;
            last.link = newNode;
            first = newNode;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            newNode.link = newNode;
            first = newNode;
            last = newNode;
        } else {
            newNode.link = first;
            last.link = newNode;
            last = newNode;
        }
    }

    static void display(Node s) {
        Node temp = s;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinedList s = new CircularLinedList();

        System.out.println("Enter your choise :");
        System.out.println("for insert at first 1, for insert at last 2, for display 3, for exit 4");
        int n = sc.nextInt();

        while (n != 4) {
            switch (n) {
                case 1:
                    int first = sc.nextInt();
                    s.insertAtFirst(first);
                    break;
                case 2:
                    int end = sc.nextInt();
                    s.insertAtLast(end);
                    break;
                case 3:
                    display();
                    break;
            }
            System.out.println("for insert at first 1, for insert at last 2, for display 3, for exit 4");
            n = sc.nextInt();
        }
    }
}
