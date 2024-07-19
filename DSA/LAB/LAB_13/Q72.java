// 72. Write a menu driven program to implement following operations on the doubly
// linked list.
//  Insert a node at the front of the linked list.
//  Delete a node from specified position.
//  Insert a node at the end of the linked list. (Home Work)
//  Display all nodes. (Home Work)

import java.util.Scanner;

/**
 * Q72
 */
public class Q72 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll1 = new DoublyLinkedList();
        outer:
        while (true) {
            System.out.println("1 for insert at first 2 for insert at last 3 for delete a node at specific position 4 for insert at specific position");
            int check=sc.nextInt();
            switch(check){
                case 1:
                    System.out.println("enter number");
                    int x = sc.nextInt();
                    dll1.insertAtFirst(x);
                    System.out.println("display ");
                    dll1.display();
                    break;
                case 2: 
                    System.out.println("enter number");
                    x=sc.nextInt();
                    dll1.insertAtEnd(x);
                    System.out.println("display ");
                    dll1.display();
                    break;
                case 3:
                    System.out.println("enter position to delete");
                    int i = sc.nextInt();
                    dll1.deleteAtPosition(i);
                    System.out.println("display ");
                    dll1.display();
                    break;
                case 4:
                    System.out.println("enter index");
                    i=sc.nextInt();
                    System.out.println("enter number");
                    x=sc.nextInt();
                    dll1.insertAtPosition(x, i);
                    System.out.println("display ");
                    dll1.display();
                    break;
                default:
                    break outer;
            }
        }
    }
}

class DoublyLinkedList{
    Node l;
    Node r;
    public void insertAtFirst(int x){
        Node newNode = new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        newNode.rpter=l;
        l.lpter=newNode;
        l=newNode;
    }
    public void insertAtEnd(int x){
        Node newNode=new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        Node save=l;
        while(save.rpter!=null){
            save=save.rpter;
        }
        save.rpter=newNode;
        newNode.lpter=save;
        r=newNode;
    }
    public void deleteAtPosition(int i){
        if(r==null){
            System.out.println("ll is empty");
            return;
        }
        if(i==0){
            l=l.rpter;
            l.lpter=null;
            return;
        }
        Node save=l;
        Node pred=save;
        int count=-1;
        while(save!=null){
            count++;
            if(count==i){
                // pred.rpter=save.rpter;
                // save.rpter.lpter=pred;
                // return;
                break;
            }
            pred=save;
            save=save.rpter;
        }
        if(save==null){
            System.out.println("out of linked link");
        }
        if(save.rpter==null){
            pred.rpter=null;
            r=pred;
            return;
        }
        pred.rpter=save.rpter;
        save.rpter.lpter=pred;
    }
    public void insertAtPosition(int x,int i){
        Node newNode = new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        if(i==0){
            insertAtFirst(x);
            return;
        }
        int count=-1;
        Node save=l;
        Node pred=save;
        while(save!=null){
            count++;
            if(count==i){
                break;
            }
            pred=save;
            save=save.rpter;
        }
        if(save==null){
            insertAtEnd(x);
            return;
        }
        pred.rpter=newNode;
        newNode.lpter=pred;
        newNode.rpter=save;
        save.lpter=newNode;
    }
    public void display(){
        Node save=l;
        while(save!=null){
            System.out.print(save.info+" ");
            save=save.rpter;
        }
        System.out.println();
    }
}   
class Node {
    int info;
    Node lpter;
    Node rpter;
    public Node(int info) {
        this.info = info;
        this.lpter = null;
        this.rpter = null;
        
    }
}