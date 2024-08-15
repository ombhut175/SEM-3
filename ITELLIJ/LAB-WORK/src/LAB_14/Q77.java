package LAB_14;

import java.util.Scanner;

public class Q77 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt1 =new BinaryTree();
        bt1.insert(sc);
        bt1.display();
    }
}

class BinaryTree{
    Node root;
    void insert(Scanner sc){
        System.out.println("enter the root node");
        int n = sc.nextInt();
        this.root = new Node(n);
        insert(sc,root);
    }
    private void insert(Scanner sc,Node node){
        System.out.println("0 to enter at the left of the node or 2 to cancel"+node.key);
        int left = sc.nextInt();
        if(left==0){
            System.out.println("enter element to enter");
            int n = sc.nextInt();
            node.left=new Node(n);
            insert(sc,node.left);
        }
        System.out.println("1 to enter at the right of the node or 2 to cancel "+node.key);
        int right = sc.nextInt();
        if(right==1){
            System.out.println("enter element to enter");
            int n = sc.nextInt();
            node.right=new Node(n);
            insert(sc,node.right);
        }
    }
//        int searchLevel=0;
//    void search(int searchNo){
//        if(root==null){
//            System.out.println("tree is empty");
//            return;
//        }
//        if(root.key==searchNo){
//            System.out.println("searched number is "+root.key);
//            return;
//        }
//        int level = search(root,searchLevel,searchNo);
//        if(level==0){
//            System.out.println("no element is founded");
//        }
//        else{
//            System.out.println("searched number is at level "+level);
//        }
//    }
//    private void search(Node n,int searchLevel,int searchNo){
//        if(n==null || n.key==searchNo){
//            searchLevel--;
//            return;
//        }
//        search(n.left,searchLevel++,searchNo);
//        search(n.right,searchLevel++,searchNo);
//    }
    void display(){
        display(root,"");
    }
    private void display(Node node,String levelSpace){
        if(node==null){
            return;
        }
        System.out.println(levelSpace+node.key);
        display(node.left,levelSpace+"\t");
        display(node.right,levelSpace+"\t");
    }
    void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node,int level){
        if (node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.println("|\t\t");
            }
            System.out.println("|-------->"+node.key);
        }else{
            System.out.println(node.key);
        }
        prettyDisplay(node.left,level+1);
    }
}