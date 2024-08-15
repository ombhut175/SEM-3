import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        int[] a = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt1.insertPreOrder(a);
        int[] b = {2,4,-1,-1,5,-1,-1};
//        BinaryTree bt2 = new BinaryTree();
            bt1.setIndex();
            Node root2 = bt1.insertPreOrder(b);
            bt1.prettyDisplay(root2);
//        bt1.prettyDisplay(root);
//        bt1.displayPre(root);
//        System.out.println();
//        bt1.displayIn(root);
//        System.out.println();
//        bt1.displayPost(root);
//        bt1.levelTraversal(root);
//        int height = bt1.height(root);
//        System.out.println(height);
//        int count = bt1.countNodes(root);
//        System.out.println(count);
//        int sum = bt1.sum(root);
//        System.out.println(sum);
//        int diameter = bt1.diameter(root);
//        System.out.println(diameter);
//        BinaryTree.Info info = bt1.diameter2(root);
//        System.out.println(info.height);
//        System.out.println(info.diameter);

            System.out.println(bt1.checkSubTree(root,root2));
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
    void setIndex(){
        idx=-1;
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
    int diameter(Node node){//O(n^2)
        if (node==null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        int ld = diameter(node.left);
        int rd = diameter(node.right);
        return Math.max(Math.max(ld,rd),lh+rh+1);
    }
    Info diameter2(Node node){//O(n) time complexity
        if(node == null) return new Info(0,0);
        Info lInfo = diameter2(node.left);
        Info rInfo = diameter2(node.right);
            int finalH = Math.max(lInfo.height,rInfo.height)+1;
            int finalD = Math.max(Math.max(lInfo.diameter,rInfo.diameter),lInfo.height+rInfo.height+1);
            return new Info(finalH,finalD);
    }
    class Info{
        int height;
        int diameter;
        Info(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }
//    private int diameter(Node node){
//        if (node==null) return 0;
//        int left = countNodes(node.left);
//        int right = countNodes(node.right);
//        return left+right+1;
//    }
    boolean checkSubTree(Node root1,Node root2){
        if (root2==null) return true;
        if (root1==null) return false;
        if (checkSubTree1(root1,root2)) return true;
        return checkSubTree(root1.left,root2) || checkSubTree(root1.right,root2);
    }
    private boolean checkSubTree1(Node root1,Node root2){
        if(root1==null && root2==null) return true;
        if (root1==null || root2==null) return false;
        if(root1.key!=root2.key) return false;
//        boolean leftTree = checkSubTree1(root1.left,root2.left);
//        boolean rightTree = checkSubTree1(root1.right,root2.right);
        return checkSubTree1(root1.left,root2.left) && checkSubTree1(root1.right,root2.right);
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