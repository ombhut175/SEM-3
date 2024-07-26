public class Q73 {
    public static void main(String[] args) {
        DoublyLL dl1 = new DoublyLL();
        dl1.insertAtEnd(1);
        dl1.insertAtEnd(2);
        dl1.insertAtEnd(3);
        dl1.insertAtEnd(4);
        dl1.insertAtEnd(5);
        dl1.insertAtEnd(6);
        dl1.insertAtEnd(7);
        dl1.deleteAlternate();
        dl1.display();
    }
}

class DoublyLL{
    Node l;
    Node r;
    void insertAtEnd(int x){
        Node newNode = new Node(x);
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
    void deleteAlternate(){
        if(l==null || l==r){
            System.out.println("invalid LL");
            return;
        }
        Node save=l.rpter;
        while (save!=null) {
            save.lpter.rpter=save.rpter;
            if(save.rpter==null){
                r=save.lpter;
                break;
            }
            save.rpter.lpter=save.lpter;
            save=save.rpter.rpter;
        }
    }
    void display(){
        Node save=l;
        while (save!=null) {
            System.out.print(save.info+" ");
            save=save.rpter;
        }
    }
}


class Node{
    int info;
    Node lpter;
    Node rpter;
    Node(int info){
        this.info=info;
        this.lpter=null;
        this.rpter=null;
    }
}
