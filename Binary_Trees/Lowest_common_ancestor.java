package Binary_Trees;

public class Lowest_common_ancestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static Node lca(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String agrs[]) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        Node ans = lca(root, root.left.left, root.left.right.left); // lca(6,7)
        System.out.println(ans.data); // ans is 5
    }
}
