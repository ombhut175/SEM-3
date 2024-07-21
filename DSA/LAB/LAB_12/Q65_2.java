import java.util.Scanner;

public class Q65_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RemoveDuplicateLL rdl1 = new RemoveDuplicateLL();
        outer:
        while (true) {
            System.out.println("enter 1 for insert");
            int check = sc.nextInt();
            switch(check){
                case 1: System.out.println("enter number");
                        int x = sc.nextInt();
                        rdl1.addLast(x);
                        rdl1.display();
                        break;
                default:
                        break outer;
            }
        }
        // rdl1.removeDuplicate();
        rdl1.sortLL();
        rdl1.display();
    }
}


class RemoveDuplicateLL{
    Node first;
    Node last;
    public void addLast(int x){
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
     public void removeDuplicate(){
        if(first==null){
            System.out.println("linked list is empty");
            return;
        }
        Node save=first;
        while (save!=null) {
            Node temp=save.link;
            Node predTemp=save;
            while (temp!=null) {
                boolean check=false;
                if(temp.info==save.info){
                    predTemp.link=temp.link;
                    check=true;
                }
                if(!check){
                    predTemp=temp;
                }
                temp=temp.link;
            }
            save=save.link;
        }
        save=first;
        while (save.link!=null) {
            save=save.link;
        }
        last=save;
    }
    void sortLL(){
        Node save = first;
        Node pred=null;
        while(save!=null){
            Node temp=save.link;
            Node predTemp=save;
            while(temp!=null){
                if(temp.info<save.info){
                    predTemp.link=temp.link;
                    temp.link=save;
                    save=temp;
                    if(pred==null){
                        first=save;
                    }
                    else{
                        pred.link=temp;
                    }
                    // pred.link=temp;
                }
                // if(count>0){
                // }
                // else{
                    // first=temp;
                // }
                predTemp=temp;
                temp=temp.link;
            }
            pred=save;
            save=save.link;
        }
    }
    void display(){
        Node save=first;
        System.out.println("entered display");
        while (save!=null) {
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
