
import LAB_15.Node;

public class pre_in {
    public static void main(String[] args) {
        int[] in = {4,2,5,1,3,6};
        int[] pre = {1,2,4,5,3,6};

    }
}


class LinkedList{
    Node root;
    int i=0;
    int j=0;

    public LinkedList(int a) {
        this.root = new Node(a);
    }
    
    void construct(int[] in,int[] pre){
        while (i!=in.length && i!=root.key) {
            i++;
        }
        int n1 = in.length-1;
        int[] left = new int[i-1];
        int[] right = new int[n1-i];
        for(int tempi=0;tempi<left.length;i++) left[tempi] = in[tempi];
    }
}

