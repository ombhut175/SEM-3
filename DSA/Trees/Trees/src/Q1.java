import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        int[] a = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt1.insertPreOrder(a);
//        bt1.prettyDisplay(root);
//        bt1.displayPre(root);
//        System.out.println();
//        bt1.displayIn(root);
//        System.out.println();
//        bt1.displayPost(root);
//        bt1.levelTraversal(root);
        int height = bt1.height(root);
        System.out.println(height);
        int count = bt1.countNodes(root);
        System.out.println(count);
        int sum = bt1.sum(root);
        System.out.println(sum);
    }
}

class BinaryTree {
    int idx=-1;
    Node insertPreOrder(int[]a){
        idx++;
        if(a[idx]==-1){
            return null;
        }
        Node newNode = new Node(a[idx]);
        newNode.left = insertPreOrder(a);
        newNode.right = insertPreOrder(a);
        return newNode;
    }
    void displayPre(Node node){
        if (node==null){
            return;
        }
        System.out.print(node.key+" ");
        displayPre(node.left);
        displayPre(node.right);
    }
    void displayIn(Node node){
        if(node==null){
            return;
        }
        displayIn(node.left);
        System.out.print(node.key+" ");
        displayIn(node.right);
    }
    void displayPost(Node node){
        if(node==null) return;
        displayPost(node.left);
        displayPost(node.right);
        System.out.print(node.key+" ");
    }
    void levelTraversal(Node node){
        if (node==null) return;
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(node);
        q1.add(null);
        while (!q1.isEmpty()){
            Node newNode = q1.poll();
            if (newNode == null){
                System.out.println();
                if (!q1.isEmpty()){
                    q1.add(null);
                }
            }else{
                System.out.print(newNode.key+" ");
                if(newNode.left!=null){
                    q1.add(newNode.left);
                }
                if(newNode.right!=null){
                    q1.add(newNode.right);
                }
            }
        }
    }
    int height(Node node){
        if (node==null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left,right)+1;
    }
    int countNodes(Node node){
        if(node==null) return 0;
        int left = countNodes(node.left);
        int right = countNodes(node.right);
        return left+right+1;
    }
    int sum(Node node){
        if(node==null) return 0;
        int a = sum(node.left);
        int b = sum(node.right);
        return node.key+a+b;
    }
    void display(Node root){
        display(root,"");
    }
    private void display(Node node, String levelSpace){
        if(node==null){
            return;
        }
        System.out.println(levelSpace+node.key);
        display(node.left,levelSpace+"\t");
        display(node.right,levelSpace+"\t");
    }
    void prettyDisplay(Node root){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node, int level){
        if (node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.key);
        }else{
            System.out.println(node.key);
        }
        prettyDisplay(node.left,level+1);
    }
}

class Node{
    int key;
    Node left;
    Node right;
    Node(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }
}