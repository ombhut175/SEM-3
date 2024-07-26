// 68. Write a program to swap two consecutive nodes in the linked list. Don’t change
// the values of nodes, implement by changing the link of the nodes.
//  Input: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
//  Output: 2 → 1 → 4 → 3 → 6 → 5 → 8 → 7

/**
 * Q68
 */
public class Q68 {

    public static void main(String[] args) {
        Swap sw1 = new Swap();
        sw1.addLast(1);
        sw1.addLast(2);
        sw1.addLast(3);
        sw1.addLast(4);
        sw1.addLast(5);
        sw1.addLast(6);
        sw1.addLast(7);
        sw1.addLast(8);
        sw1.addLast(9);
        sw1.addLast(10);
        sw1.swapConsecutive();
        sw1.display();
    }
}

class Swap{
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
    void swapConsecutive(){
        if(first==null || first==last){
            System.out.println("invalid LL");
            return;
        }
        Node save = first;
        Node pred=null;
        Node succ = save.link;
        // boolean check1 = false;
        // boolean check2 = false;
        while(save!=null){
                save.link=succ.link;
                succ.link=save;
                if(pred!=null){
                    pred.link=succ;
                }
            if(pred==null){
                first=succ;
                // check1=true;
            }
            Node temp=save;
            save= succ;
            succ=temp;
            if(succ.link==null){
                break;
            }
            pred=save.link;
            save=save.link.link;
            succ=save.link;
            if(succ==null){
                break;
            }
        }
        if(succ!=null && save.link==null){
            last=succ;
        }
    }
    void display(){
        Node save=first;
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