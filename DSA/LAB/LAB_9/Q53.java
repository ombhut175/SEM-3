// 53. Implement Priority Queue using array that performs following operations:
// INSERT, DELETE, DISPLAY

import java.util.Scanner;

public class Q53 {

    public static void main(String[] args) {
        PriorityQueueUsingLL pqull = new PriorityQueueUsingLL();
        // pqull.addLast(1, 1);
        // pqull.addLast(2, 2);
        // pqull.addLast(3, 2);
        // pqull.addLast(4, 3);
        // pqull.addLast(5, 3);
        // pqull.addLast(6, 1);
        // pqull.removeFirst();
        // pqull.removeFirst();
        // pqull.display();
        Scanner sc = new Scanner(System.in);
        outer:
        while (true) {
            System.out.println("1 for insert 2 for delete 3 for exit");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                    System.out.println("enter number");
                    int x = sc.nextInt();
                    System.out.println("enter priority");
                    int p = sc.nextInt();
                    pqull.addLast(x, p);
                    pqull.display();
                    break;
                case 2:
                    pqull.removeFirst();
                    pqull.display();
                    break;
                default:
                    break outer;
            }
        }

    }
}

class PriorityQueueUsingLL {

    Node first;
    Node last;

    void addLast(int x, int p) {
        Node newNode = new Node(x, p);
        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        Node save = first;
        while (save.link != null && save.priority != newNode.priority) {
            save = save.link;
        }
        while (save.link != null && save.link.priority == newNode.priority) {
            save = save.link;
        }
        if (save.link == null) {
            save.link = newNode;
            last = newNode;
            return;
        }
        newNode.link = save.link;
        save.link = newNode;
    }

    void removeFirst() {
        if (first == null) {
            System.out.println("queue is empty");
            return;
        }
        first = first.link;
    }

    void display() {
        Node save = first;
        while (save != null) {
            System.out.print(save.info + " ");
            save = save.link;
        }
        System.out.println();
    }
}

class Node {

    int info;
    int priority;
    Node link;

    Node(int info, int priority) {
        this.info = info;
        this.priority = priority;
        this.link = null;
    }
}
