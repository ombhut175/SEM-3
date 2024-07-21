public class checking {
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(5);
        Node e = new Node(9);
        a.link=b;
        b.link=c;
        c.link=d;
        d.link=e;
        Node first = a;
        Node save = first;
        Node pred=null;
        int count=0;
        while(save!=null){
            Node temp=save.link;
            Node predTemp=save;
            while(temp!=null){
                boolean check=false;
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
            count++;
            pred=save;
            save=save.link;
        }
        System.out.println("first.info = "+first.info);      
        save=first;
        while (save!=null) {
            System.out.print(save.info+" ");
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