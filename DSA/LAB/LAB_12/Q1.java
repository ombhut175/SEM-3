import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingLL sll1 = new StackUsingLL();
        outer:
        while (true) {
            System.out.println("1 for push 2 for pop 3 peep 4 for change 5 for exit");
            int check=sc.nextInt();
            switch (check) {
                case 1:
                    System.out.println("enter number");
                    int x = sc.nextInt();
                    sll1.push(x);
                    sll1.display();
                    break;
                case 2:
                    sll1.pop();
                    sll1.display();
                    break;
                case 3:
                    System.out.println("enter position of element");
                    int i = sc.nextInt();
                    sll1.peep(i);
                    sll1.display();
                    break;
                case 4:
                    System.out.println("enter position");
                    i = sc.nextInt();
                    System.out.println("enter number");
                    x=sc.nextInt();
                    sll1.change(x, i);
                    sll1.display();
                    break;
                case 5:
                    break outer;
            }
        }
    }
}

class StackUsingLL{
    Node first;
    Node last;
    public void push(int x){
        Node newNode = new Node(x);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }   
        Node save=first;
        while(save.link!=null){
            save=save.link;
        }
        save.link=newNode;
        last=newNode;
     }
     public void pop(){
        if(first==null){
            System.out.println("stack is empty");
            return;
        }
        if(first.link==null){
            first=first.link;
            return;
        }
        Node save = first;
        Node pred=save;
        while(save.link!=null){
            pred=save;
            save=save.link;
        }
        pred.link=null;
        last=pred;
     }
     public void peep(int i){
        if(first==null){
            System.out.println("stack is empty");;
            return;
        }
        Node save=first;
        int count=-1;
        while (save!=null) {
            count++;
            save=save.link;
        }
        if(count-i<0){
            System.out.println("stack underflow");
            return;
        }
        int tempCount = -1;
        save=first;
        while(save!=null){
            tempCount++;
            if(tempCount==count-i){
                break;
            }
            save=save.link;
        }
        System.out.println("element = "+save.info);
     }
     public void change(int x,int i){
        Node newNode= new Node(x);
        int count=-1;
        Node save=first;
        while(save!=null){
            count++;
            save=save.link;
        }
        if(count-i<0){
            System.out.println("stack underflow");
            return;
        }
        save=first;
        Node pred=save;
        int tempCount=-1;
        while(save!=null){
            tempCount++;
            if(tempCount==count-i){
                break;
            }
            pred=save;
            save=save.link;
        }
        if(save==first){
            newNode.link=save.link;
            first=newNode;
            return;
        }
        if(save==null){
            pred.link=newNode;
            last=newNode;
            return;
        }
        newNode.link=save.link;
        pred.link=newNode;
     }
     public void display(){
        Node save=first;
        while(save!=null){
            System.out.print(save.info+" ");
            save=save.link;
        }
        System.out.println();
     }
}

class Node {
    int info;
    Node link;
    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}