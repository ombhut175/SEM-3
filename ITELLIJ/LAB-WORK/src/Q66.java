import javax.print.DocFlavor;

public class Q66 {
    public static void main(String[] args) {
        SwapLL sl1 = new SwapLL();
    }
}

class SwapLL{
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
    void swap(int start,int end){
        if(first==null){
            System.out.println("list is empty");
            return;
        }
        int count=-1;
        Node save = first;
        while(save!=null){
            count++;
            save=save.link;
        }
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