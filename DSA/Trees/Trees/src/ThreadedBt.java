import java.util.ArrayList;
import java.util.Queue;

public class ThreadedBt {
	public static void main(String[] args) {
		ThreadedBinaryTree tbt1 = new ThreadedBinaryTree();
		int[] a = {10,20,30,-1,-1,-1,40,50,-1,70,-1,-1,60,-1,-1};
		ThNode root =tbt1.insertPre(a);
		ThNode head = new ThNode(-1);
		head.left=root;
		tbt1.prettyDisplay(root);
		tbt1.setI();
		ArrayList<ThNode> a1 = new ArrayList<>();
		tbt1.inOrder(root,a1);
		ThNode thRoot = tbt1.construct(root,head,a1);
//		System.out.println(thRoot.key);
//		tbt1.thTraversalUsingRecursion(thRoot);
//		System.out.println("checking");
//		System.out.println(root.left.right.key);
//		System.out.println(root.left.rth);
		tbt1.thTraversalUsingLoop(thRoot,head);
	}
}

class ThreadedBinaryTree{
	int i=-1;
//	ThNode insertPre(int[] a){
//		return insertPre(a);
//	}
	ThNode insertPre(int[] a){
		i++;
//		System.out.print(a[i]+" ");
		if (a[i]==-1) return null;
		ThNode newNode = new ThNode(a[i]);
		newNode.left = insertPre(a);
		newNode.right = insertPre(a);
		return newNode;
	}
	void setI(){
		this.i=-1;
	}
	ThNode construct(ThNode node,ThNode head,ArrayList<ThNode> a1){
//		if (node==null || node==head || node.lth || node.rth) return null;
		if (node.left==null){
			int i = a1.indexOf(node);
			if(!(i-1<0)){
//				ThNode pred = a1.get(i-1);
				node.left= a1.get(i-1);
//				node.lth=true;
			}else{
				node.left=head;
			}
				node.lth=true;
		}
		if (node.right==null){
			int i = a1.indexOf(node);
			if (!(i+1>=a1.size())){
//				ThNode suc = a1.get(i+1);
				node.right = a1.get(i+1);
//				node.rth=true;
			}else{
				node.right=head;
			}
				node.rth=true;
		}
		if (node.left!=null && !node.lth) construct(node.left,head,a1);
		if (node.right!=null && !node.rth)construct(node.right,head,a1);
		return node;
	}

	void inOrder(ThNode node,ArrayList<ThNode> a1){
		if(node==null) return;
		inOrder(node.left,a1);
		a1.add(node);
		inOrder(node.right,a1);
	}
	void thTraversalUsingRecursion(ThNode node){
		if (node.left!=null && !node.lth){
			thTraversalUsingRecursion(node.left);
		}
		System.out.print(node.key+" ");
		if (node.right!=null && !node.rth){
			thTraversalUsingRecursion(node.right);
		}
	}
	void thTraversalUsingLoop(ThNode node,ThNode head){
		if (node==null) return;
		ThNode curr = leftMostNode(node);
		while (curr!=head){
			System.out.print(curr.key+" ");
			if (curr.rth) curr=curr.right;
			else curr=leftMostNode(curr.right);
		}
	}
	private ThNode leftMostNode(ThNode node){
		if (node==null) return null;
		while (!node.lth) node=node.left;
		return node;
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

class ThNode {
	int key;
	ThNode left,right;
	boolean lth,rth;
	public ThNode(int key){
		this.key=key;
		left=right=null;
		lth=rth=false;
	}
}
