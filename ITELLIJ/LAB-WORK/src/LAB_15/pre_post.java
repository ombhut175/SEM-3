package LAB_15;

public class pre_post {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        BinaryTree2 bt2 = new BinaryTree2();

        Node root = bt2.buildTree(pre, post);

        System.out.println("Inorder traversal of the constructed tree:");
        bt2.printInOrder(root);
    }
}

class BinaryTree2 {
    private int preIndex = 0;

    // Function to construct binary tree from preorder and postorder traversals
    Node construct(int[] pre, int[] post, int l, int h) {
        // Base case
        if (l > h || preIndex >= pre.length) {
            return null;
        }

        // Create a new node with the current value in preorder traversal
        Node node = new Node(pre[preIndex++]);

        // If there is only one element, return it
        if (l == h) {
            return node;
        }

        // Find the index of the next element in preorder in the postorder sequence
        int i;
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preIndex]) {
                break;
            }
        }

        // If we found a valid index
        if (i <= h) {
            // Construct the left subtree
            node.left = construct(pre, post, l, i);
            // Construct the right subtree
            node.right = construct(pre, post, i + 1, h - 1);
        }

        return node;
    }

    // Wrapper function
    Node buildTree(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0 || pre.length != post.length) {
            return null;
        }
        return construct(pre, post, 0, post.length - 1);
    }

    // Function to print inorder traversal of the binary tree
    void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }
}