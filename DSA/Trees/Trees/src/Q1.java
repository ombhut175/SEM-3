import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        int[] a = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt1.insertPreOrder(a);
        int[] b = {2,4,-1,-1,5,-1,-1};
//        BinaryTree bt2 = new BinaryTree();
            bt1.setIndex();
            Node root2 = bt1.insertPreOrder(b);
//            bt1.prettyDisplay(root2);
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
//            System.out.println(bt1.checkSubTree(root,root2));
//            bt1.setIndex();
//            int[] c = {1,2,-1,4,-1,5,-1,6,-1,-1,3,-1,-1};
//            Node root3 = bt1.insertPreOrder(c);
            bt1.setIndex();
//            bt1.prettyDisplay(root3);
//            bt1.displayTop(root3);
//             bt1.printKthLevel(root3,6);
                int[] d = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
                Node root4 = bt1.insertPreOrder(d);
//                bt1.prettyDisplay(root4);
                bt1.setIndex();
//                bt1.printKthLevelRecursion(root4,3);
//                System.out.println(bt1.lowestCommonAncestor(root, 4, 5).key);
//                System.out.println(bt1.lca(root, 4, 6).key);
//                    System.out.println(bt1.minDistance(root4,4,5));
//                        System.out.println(bt1.minDistance2(root4,4,6));
//                            System.out.println(bt1.kThAncestor(root4,4,2));
//                                bt1.kThAncestor(root4,6,1);
//                                    System.out.println("sum = "+bt1.sumTree(root4));
//                                      bt1.prettyDisplay(root4);
                     int[] e = {2,2,5,-1,-1,2,-1,-1,2,-1,-1};
                     Node rootE = bt1.insertPreOrder(e);
                     bt1.prettyDisplay(rootE);
                    // System.out.println(bt1.checkUnivalued(rootE));
                    // System.out.println(bt1.checkUnivalued(root4));
                    System.out.println(bt1.checkCopy(root, root));
    }
}

class BinaryTree {
    int idx=-1;
    Node insertPreOrder(int[] a){
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
    boolean checkCopy(Node node1 ,Node node2){
        if(node1!=node2) return false;
        if(node1==null && node2==null) return true;
        if(node1==null && node2!=null || node1!=null && node2==null) return false;
        // boolean left = checkCopy(node1.left, node2.left);
        // boolean right = checkCopy(node1.right, node2.right);
        return checkCopy(node1.left, node2.left)&&checkCopy(node1.right, node2.right);
    }
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
        return checkSubTree1(root1.left,root2.left) && checkSubTree1(root1.right,root2.right);
    }
    private class Info1{
        Node node;
        int hd;
        Info1(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    void displayTop(Node root){
        if (root==null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<Info1> qi1 = new LinkedList<>();
        HashMap<Integer,Node> hm1 = new HashMap<>();
        int min=0,max=0;
        qi1.add(new Info1(root,0));
        qi1.add(null);
        while (!qi1.isEmpty()){
            Info1 curr = qi1.remove();
            if (curr==null){
                if (!qi1.isEmpty()){
                    qi1.add(null);
                }
            }
            else {
                if (!hm1.containsKey(curr.hd)) hm1.put(curr.hd, curr.node);
                if (curr.node.left!=null){
                    qi1.add(new Info1(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right!=null){
                    qi1.add(new Info1(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(hm1.get(i).key+" ");
        }
    }
    void printKthLevel(Node root,int k){
        if (root==null) return;
        if (k==1) {
            System.out.println(root.key);
            return;
        }
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(null);
        int count = 1;
        boolean check = false;
        while (!q1.isEmpty()){
            Node curr = q1.remove();
            if (curr==null){
                count++;
                check = count == k;
                if (!q1.isEmpty()){
                    q1.add(null);
                }
            }else {
                if (check){
                    System.out.print(curr.key+" ");
                }
                if (curr.left!=null) q1.add(curr.left);
                if (curr.right!=null) q1.add(curr.right);
            }
        }

    }
    void printKthLevelRecursion(Node node,int k){
        if (node==null){
            System.out.println("LL is empty");
            return;
        }
        printKthLevelRecursion(node,k,1);
    }
    private void printKthLevelRecursion(Node node,int k,int count){
        if (node==null) return;
        if (count==k) {
            System.out.print(node.key+" ");
            return;
        }
        printKthLevelRecursion(node.left,k, count+1);
        printKthLevelRecursion(node.right,k,count+1);
    }
    Node lowestCommonAncestor(Node node,int n1,int n2){
            ArrayList<Node> a1 = new ArrayList<>();
            ArrayList<Node> a2 = new ArrayList<>();
            getPath(node,n1,a1);
            getPath(node,n2,a2);
            int i=0;
            for (;i<a1.size() && i<a2.size();i++){
                if (a1.get(i)!=a2.get(i)) break;
            }
            return a1.get(i-1);
    }
    boolean getPath(Node node,int n,ArrayList<Node> a1){
        if(node==null) return false;
        a1.add(node);
        if (node.key==n) return true;
        if (getPath(node.left,n,a1) || getPath(node.right,n,a1)) return true;
        a1.removeLast();
        return false;
    }
    Node lca(Node node,int n1,int n2){
        if (node==null || node.key==n1 || node.key==n2) return node;
        Node left = lca(node.left,n1,n2);
        Node right = lca(node.right,n1,n2);
        if (left==null) return right;
        if (right==null) return left;
        return node;
    }

        int minDistance(Node node,int n1,int n2){
        if (node==null) return 0;
        if (node.key==n1 || node.key==n2){
            int height = height(node);
        }
        Node lca = lca(node,n1,n2);
        ArrayList<Node> a1 = new ArrayList<>();
        ArrayList<Node> a2 = new ArrayList<>();
        getPath(lca,n1,a1);
        getPath(lca,n2,a2);
        int i=0,j=0,count=0;
//        System.out.println("size of a1 = "+a1.size());
//        System.out.println(a2.size());
        while (i<a1.size() && j<a2.size()){
//            for (i=0,j=0;i<a1.size()&&j<a2.size();i++,j++) {
                if (a1.get(i) == a2.get(j)) {
//                    System.out.println("count inside loop 1 = " + count);
                    count = count + 1;
                }else {
                    count+=2;
                }
//                System.out.println("a1.get(i) "+a1.get(i).key);
//                System.out.println("a2.get(j) "+a2.get(j).key);
                i++;
                j++;
            }
//        }
        while (i<a1.size()) {
//            System.out.println("count inside loop 2 = "+count);
            count=count+1;
            i++;
        }
        while (j<a2.size()) {
//            System.out.println("count inside loop 3 = "+count);
            count=count+1;
            j++;
        }
        return count-1;
    }
    int minDistance2(Node node,int n1,int n2){
        Node lca = lowestCommonAncestor(node,n1,n2);
        int left = minDistance2(lca,n1);
        int right = minDistance2(lca,n2);
        return left+right;
    }
    private int minDistance2(Node node,int n1){
            if (node==null) return -1;
            if (node.key == n1) return 0;
            int left = minDistance2(node.left,n1);
            if (left!=-1) return left+1;
            int right = minDistance2(node.right,n1);
            if (right!=-1) return right+1;
            return -1;
    }
    boolean isSymmetric(Node root) {
        if(root==null) return true;
        return checkSymmetry(root.left,root.right);
    }
    private boolean checkSymmetry(Node left,Node right){
        if(left==null && right==null) return true;
        if(left==null && right!=null || left!=null && right==null) return false;
        if(left.val!=right.val) return false;
        return checkSymmetry(left.left,right.right)&&checkSymmetry(left.right,right.left);
    }
    private boolean minDistance(Node node,int n1,ArrayList<Node> a1){
        if (node==null) return false;
        a1.add(node);
        if (node.key==n1) return true;
//        boolean left = minDistance(node.left,n1,a1);
//        boolean right = minDistance(node.right,n1,a1);
        if (minDistance(node.left,n1,a1) || minDistance(node.right,n1,a1)) return true;
        a1.removeLast();
        return false;
    }
    int kThAncestor(Node root,int n, int k){
        if (root==null) return -1;
        if (root.key==n) return 0;
        int left = kThAncestor(root.left,n,k);
        if (left+1==k) System.out.println(root.key);
        if (left!=-1) return left+1;
        int right = kThAncestor(root.right,n,k);
        if (right+1==k) System.out.println(root.key);
        if (right!=-1) return right+1;
        return -1;
    }
    int sumTree(Node root){
        if (root==null) {
            return 0;
        }
        int left = sumTree(root.left);
        int right =sumTree(root.right);
        int sum = left+right;
        int a = root.key;
        root.key = sum;
        return sum+a;
    }
    boolean checkUnivalued(Node root){
        if (root==null){
            System.out.println("tree is empty");
            return false;
        }
        ArrayList<Node> a1 = new ArrayList<>();
        graphInAl(root,a1);
        for (int i = 0; i < a1.size(); i++) {
            for (int j = i+1; j < a1.size(); j++) {
                if (a1.get(i).key!=a1.get(j).key) return false;
            }
        }
        return true;
    }
    private void graphInAl(Node root, ArrayList<Node> a1){
            if(root==null) return;
            a1.add(root);
            graphInAl(root.left,a1);
            graphInAl(root.right,a1);
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