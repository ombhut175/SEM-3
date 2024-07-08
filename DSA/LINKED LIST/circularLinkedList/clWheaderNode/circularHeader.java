public class circularHeader {
    public static void main(String[] args) {
        circularHeaderLL cl1 = new circularHeaderLL();
        cl1.cir_head_ins_first(50);
        cl1.cir_head_ins_first(40);
        cl1.cir_head_ins_first(30);
        cl1.cir_head_ins_first(20);
        cl1.display();
        cl1.addLast(60);
        cl1.addLast(70);
        cl1.addLast(80);
        cl1.addLast(90);
        cl1.display();
        cl1.insertAfter(60, 65);
        // cl1.insertAfter(75, 80);
        cl1.insertAfter(90, 95);
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
        if(first==null){
            head.link=first;
            head.link=newNode;
            newNode.link=head;
            first=newNode;
            last=newNode;
            return;
        }
        newNode.link=head.link;
        head.link=newNode;
        first=newNode;
    }
    public void addLast(int x){
        Node newNode = new Node(x);
        if(first==null){
            head.link=first;
            head.link=newNode;
            newNode.link=head;
            last=newNode;
            first=newNode;
            return;
        }
        last.link=newNode;
        last=newNode;
        newNode.link=head;
    }
    public void insertAfter(int x,int newValue){
        Node newNode = new Node(newValue);
        if(head==null){
            head.link=first;
            head.link=newNode;
            newNode.link=head;
            last=newNode;
            first=newNode;
            return;
        }
        Node save = first;
        while(save!=last && save.info!=x){
            save=save.link;
        }
        if(save.info!=x){
            System.out.println("element not found");
            return;
        }
        if(save.info==x && save==last){
            addLast(newValue);
        }
        else{
            newNode.link=save.link;
            save.link=newNode;
        }
    }
    public void display(){
        Node save=first;
        do{
            System.out.print(save.info+" ");
            save=save.link;
        }while(save!=head);
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