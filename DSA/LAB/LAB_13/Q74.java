// WAP to split a circular linked list into two halves.
public class Q74 {
    public static void main(String[] args) {
        CircularLL cl1 = new CircularLL();
        CircularLL cl2 = new CircularLL();
        cl1.addLast(1);
        cl1.addLast(2);
        // cl1.addLast(3);
        // cl1.addLast(4);
        // cl1.addLast(5);
        // cl1.addLast(6);
        cl1.splitCirLL(cl2);
        cl1.display();
        cl2.display();
    }
}


class CircularLL{
    Node first;
    Node last;
    void addLast(int x){
        Node newNode = new Node(x);
        if(first==null){
            first=newNode;
            last=newNode;
            last.link=first;
            return;
        }
        Node save=first.link;
        while (save.link!=first) {
            save=save.link;
        }
        save.link=newNode;
        newNode.link=first;
        last=newNode;
    }
    void splitCirLL(CircularLL cl2){
        if(first==null){
            System.out.println("invalid LL");
            return;
        }
        int count=-1;
        Node save=this.first;
        do{
            count++;
            save=save.link;
        }while(save!=this.first);
        if(count==0){
            System.out.println("invalid LL");
            return;
        }
        save=this.first;
        Node suc = save.link;
        int count1=-1;
        do{
            count1++;
            if(count1==(count/2)){
                break;
            }
            save=save.link;
            suc=save.link;
        }while(save.link!=first);
        save.link=first;
        last=save;
        while(suc!=this.first){
            cl2.addLast(suc.info);
            suc=suc.link;
        }
    }
    void display(){
        Node save=first;
        do{
            System.out.print(save.info+" ");
            save=save.link;
        }while(save!=first);
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