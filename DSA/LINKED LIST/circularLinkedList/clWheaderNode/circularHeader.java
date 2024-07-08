public class circularHeader {
    public static void main(String[] args) {
        circularHeaderLL cl1 = new circularHeaderLL();
        cl1.cir_head_ins_first(50);
        cl1.cir_head_ins_first(40);
        cl1.cir_head_ins_first(30);
        cl1.cir_head_ins_first(20);
        cl1.display();
    }    
}
class circularHeaderLL{
    Node head = new Node(-1);
    Node first;
    Node last;
    // public circularHeaderLL(){
    //     head.link=first;
    // }
    public void cir_head_ins_first(int x){
        Node newNode = new Node(x);
        head.link=first;
        if(first==null){
            head.link=newNode;
            newNode.link=head;
            first=newNode;
            return;
        }
        newNode.link=head.link;
        head.link=newNode;
        first=newNode;
    }
    public void display(){
        Node save=first;
        do{
            System.out.print(save.info+" ");
            save=save.link;
        }while(save!=head);
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