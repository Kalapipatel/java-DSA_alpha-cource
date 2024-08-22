package Binary_Trees;

public class Symmetrical_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static boolean isSymmetricUtil(Node root1, Node root2) {
        // Check if either subtree is null
        if (root1 == null || root2 == null) {
            // If one subtree is null, the other
            // must also be null for symmetry
            return root1 == root2;
        }
        // Check if the data in the current nodes is equal
        // and recursively check for symmetry in subtrees
        return (root1.data == root2.data)
                && isSymmetricUtil(root1.left, root2.right)
                && isSymmetricUtil(root1.right, root2.left);
    }

    public static boolean isSymmetric(Node root) {
        // Check if the tree is empty
        if (root == null) {
            // An empty tree is
            // considered symmetric
            return true;
        }
        // Call the utility function
        // to check symmetry of subtrees
        return isSymmetricUtil(root.left, root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);

        System.out.println(isSymmetric(root));
    }
}
