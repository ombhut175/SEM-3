import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        int[] a = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        ThNode root = bt1.insertPreOrder(a);
        int[] b = {2,4,-1,-1,5,-1,-1};
//        BinaryTree bt2 = new BinaryTree();
            bt1.setIndex();
            ThNode root2 = bt1.insertPreOrder(b);
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
                ThNode root4 = bt1.insertPreOrder(d);
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
                     ThNode rootE = bt1.insertPreOrder(e);
                     bt1.prettyDisplay(rootE);
                    // System.out.println(bt1.checkUnivalued(rootE));
                    // System.out.println(bt1.checkUnivalued(root4));
                    System.out.println(bt1.checkCopy(root, root));
    }
}

class BinaryTree {
    int idx=-1;
    ThNode insertPreOrder(int[] a){
        idx++;
        if(a[idx]==-1){
            return null;
        }
        ThNode newThNode = new ThNode(a[idx]);
        newThNode.left = insertPreOrder(a);
        newThNode.right = insertPreOrder(a);
        return newThNode;
    }
    void setIndex(){
        idx=-1;
    }
    void displayPre(ThNode thNode){
        if (thNode ==null){
            return;
        }
        System.out.print(thNode.key+" ");
        displayPre(thNode.left);
        displayPre(thNode.right);
    }
    void displayIn(ThNode thNode){
        if(thNode ==null){
            return;
        }
        displayIn(thNode.left);
        System.out.print(thNode.key+" ");
        displayIn(thNode.right);
    }
    void displayPost(ThNode thNode){
        if(thNode ==null) return;
        displayPost(thNode.left);
        displayPost(thNode.right);
        System.out.print(thNode.key+" ");
    }
    void levelTraversal(ThNode thNode){
        if (thNode ==null) return;
        Queue<ThNode> q1 = new LinkedList<ThNode>();
        q1.add(thNode);
        q1.add(null);
        while (!q1.isEmpty()){
            ThNode newThNode = q1.poll();
            if (newThNode == null){
                System.out.println();
                if (!q1.isEmpty()){
                    q1.add(null);
                }
            }else{
                System.out.print(newThNode.key+" ");
                if(newThNode.left!=null){
                    q1.add(newThNode.left);
                }
                if(newThNode.right!=null){
                    q1.add(newThNode.right);
                }
            }
        }
    }
    int height(ThNode thNode){
        if (thNode ==null) return 0;
        int left = height(thNode.left);
        int right = height(thNode.right);
        return Math.max(left,right)+1;
    }
    int countNodes(ThNode thNode){
        if(thNode ==null) return 0;
        int left = countNodes(thNode.left);
        int right = countNodes(thNode.right);
        return left+right+1;
    }
    int sum(ThNode thNode){
        if(thNode ==null) return 0;
        int a = sum(thNode.left);
        int b = sum(thNode.right);
        return thNode.key+a+b;
    }
    int diameter(ThNode thNode){//O(n^2)
        if (thNode ==null) return 0;
        int lh = height(thNode.left);
        int rh = height(thNode.right);
        int ld = diameter(thNode.left);
        int rd = diameter(thNode.right);
        return Math.max(Math.max(ld,rd),lh+rh+1);
    }
    Info diameter2(ThNode thNode){//O(n) time complexity
        if(thNode == null) return new Info(0,0);
        Info lInfo = diameter2(thNode.left);
        Info rInfo = diameter2(thNode.right);
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
    boolean checkCopy(ThNode thNode1, ThNode thNode2){
        if(thNode1 != thNode2) return false;
        if(thNode1 ==null && thNode2 ==null) return true;
        if(thNode1 ==null && thNode2 !=null || thNode1 !=null && thNode2 ==null) return false;
        // boolean left = checkCopy(node1.left, node2.left);
        // boolean right = checkCopy(node1.right, node2.right);
        return checkCopy(thNode1.left, thNode2.left)&&checkCopy(thNode1.right, thNode2.right);
    }
    boolean checkSubTree(ThNode root1, ThNode root2){
        if (root2==null) return true;
        if (root1==null) return false;
        if (checkSubTree1(root1,root2)) return true;
        return checkSubTree(root1.left,root2) || checkSubTree(root1.right,root2);
    }
    private boolean checkSubTree1(ThNode root1, ThNode root2){
        if(root1==null && root2==null) return true;
        if (root1==null || root2==null) return false;
        if(root1.key!=root2.key) return false;
        return checkSubTree1(root1.left,root2.left) && checkSubTree1(root1.right,root2.right);
    }
    private class Info1{
        ThNode thNode;
        int hd;
        Info1(ThNode thNode, int hd){
            this.thNode = thNode;
            this.hd = hd;
        }
    }
    void displayTop(ThNode root){
        if (root==null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<Info1> qi1 = new LinkedList<>();
        HashMap<Integer, ThNode> hm1 = new HashMap<>();
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
                if (!hm1.containsKey(curr.hd)) hm1.put(curr.hd, curr.thNode);
                if (curr.thNode.left!=null){
                    qi1.add(new Info1(curr.thNode.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.thNode.right!=null){
                    qi1.add(new Info1(curr.thNode.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(hm1.get(i).key+" ");
        }
    }
    void printKthLevel(ThNode root, int k){
        if (root==null) return;
        if (k==1) {
            System.out.println(root.key);
            return;
        }
        Queue<ThNode> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(null);
        int count = 1;
        boolean check = false;
        while (!q1.isEmpty()){
            ThNode curr = q1.remove();
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
    void printKthLevelRecursion(ThNode thNode, int k){
        if (thNode ==null){
            System.out.println("LL is empty");
            return;
        }
        printKthLevelRecursion(thNode,k,1);
    }
    private void printKthLevelRecursion(ThNode thNode, int k, int count){
        if (thNode ==null) return;
        if (count==k) {
            System.out.print(thNode.key+" ");
            return;
        }
        printKthLevelRecursion(thNode.left,k, count+1);
        printKthLevelRecursion(thNode.right,k,count+1);
    }
    ThNode lowestCommonAncestor(ThNode thNode, int n1, int n2){
            ArrayList<ThNode> a1 = new ArrayList<>();
            ArrayList<ThNode> a2 = new ArrayList<>();
            getPath(thNode,n1,a1);
            getPath(thNode,n2,a2);
            int i=0;
            for (;i<a1.size() && i<a2.size();i++){
                if (a1.get(i)!=a2.get(i)) break;
            }
            return a1.get(i-1);
    }
    boolean getPath(ThNode thNode, int n, ArrayList<ThNode> a1){
        if(thNode ==null) return false;
        a1.add(thNode);
        if (thNode.key==n) return true;
        if (getPath(thNode.left,n,a1) || getPath(thNode.right,n,a1)) return true;
        a1.removeLast();
        return false;
    }
    ThNode lca(ThNode thNode, int n1, int n2){
        if (thNode ==null || thNode.key==n1 || thNode.key==n2) return thNode;
        ThNode left = lca(thNode.left,n1,n2);
        ThNode right = lca(thNode.right,n1,n2);
        if (left==null) return right;
        if (right==null) return left;
        return thNode;
    }

        int minDistance(ThNode thNode, int n1, int n2){
        if (thNode ==null) return 0;
        if (thNode.key==n1 || thNode.key==n2){
            int height = height(thNode);
        }
        ThNode lca = lca(thNode,n1,n2);
        ArrayList<ThNode> a1 = new ArrayList<>();
        ArrayList<ThNode> a2 = new ArrayList<>();
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
    ThNode constructFromArr(int[] a, int i){
        if(i>=a.length) return null;
        ThNode newThNode = new ThNode(a[i]);
        newThNode.left = constructFromArr(a, 2*i+1);
        newThNode.right = constructFromArr(a, 2*i+2);
        return newThNode;
    }
    int minDistance2(ThNode thNode, int n1, int n2){
        ThNode lca = lowestCommonAncestor(thNode,n1,n2);
        int left = minDistance2(lca,n1);
        int right = minDistance2(lca,n2);
        return left+right;
    }
    private int minDistance2(ThNode thNode, int n1){
            if (thNode ==null) return -1;
            if (thNode.key == n1) return 0;
            int left = minDistance2(thNode.left,n1);
            if (left!=-1) return left+1;
            int right = minDistance2(thNode.right,n1);
            if (right!=-1) return right+1;
            return -1;
    }
    boolean isSymmetric(ThNode root) {
        if(root==null) return true;
        return checkSymmetry(root.left,root.right);
    }
    private boolean checkSymmetry(ThNode left, ThNode right){
        if(left==null && right==null) return true;
        if(left==null && right!=null || left!=null && right==null) return false;
        if(left.key!=right.key) return false;
        return checkSymmetry(left.left,right.right)&&checkSymmetry(left.right,right.left);
    }
    private boolean minDistance(ThNode thNode, int n1, ArrayList<ThNode> a1){
        if (thNode ==null) return false;
        a1.add(thNode);
        if (thNode.key==n1) return true;
//        boolean left = minDistance(node.left,n1,a1);
//        boolean right = minDistance(node.right,n1,a1);
        if (minDistance(thNode.left,n1,a1) || minDistance(thNode.right,n1,a1)) return true;
        a1.removeLast();
        return false;
    }
    int kThAncestor(ThNode root, int n, int k){
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
    int sumTree(ThNode root){
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
    boolean checkUnivalued(ThNode root){
        if (root==null){
            System.out.println("tree is empty");
            return false;
        }
        ArrayList<ThNode> a1 = new ArrayList<>();
        graphInAl(root,a1);
        for (int i = 0; i < a1.size(); i++) {
            for (int j = i+1; j < a1.size(); j++) {
                if (a1.get(i).key!=a1.get(j).key) return false;
            }
        }
        return true;
    }
    private void graphInAl(ThNode root, ArrayList<ThNode> a1){
            if(root==null) return;
            a1.add(root);
            graphInAl(root.left,a1);
            graphInAl(root.right,a1);
    }
    void display(ThNode root){
        display(root,"");
    }
    private void display(ThNode thNode, String levelSpace){
        if(thNode ==null){
            return;
        }
        System.out.println(levelSpace+ thNode.key);
        display(thNode.left,levelSpace+"\t");
        display(thNode.right,levelSpace+"\t");
    }
    void prettyDisplay(ThNode root){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(ThNode thNode, int level){
        if (thNode ==null){
            return;
        }
        prettyDisplay(thNode.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+ thNode.key);
        }else{
            System.out.println(thNode.key);
        }
        prettyDisplay(thNode.left,level+1);
    }
}

class Node{
    int key;
    ThNode left;
    ThNode right;
    Node(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }
}