package BST;

class TreeNode {
    int val;
    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        // Traverse until root is not null
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        // Return the inorder successor node
        return successor;
    }
}

public class inOrderSuccessor {
    static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Main method
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Constructing the BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.print("BST: ");
        printInOrder(root);
        System.out.println();

        // Node for which we want to
        // find the inorder successor
        TreeNode p = root.left.right;

        // Find the inorder successor
        TreeNode successor = solution.inorderSuccessor(root, p);

        // Print the inorder successor's value
        if (successor != null) {
            System.out.println("Inorder Successor of " + p.val + " is: " + successor.val);
        } else {
            System.out.println("Inorder Successor of " + p.val + " does not exist.");
        }
    }
}
