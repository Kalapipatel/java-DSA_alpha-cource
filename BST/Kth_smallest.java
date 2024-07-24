package BST;

class Kth_smallest {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node createBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = createBST(root.left, data);
        } else {
            root.right = createBST(root.right, data);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int c = 0;

    public static void ksmallest(Node root, int k) {
        if (root == null) {
            return;
        }

        ksmallest(root.left, k);
        c++;
        if (c == k) {
            System.out.println(root.data);
            return;
        }

        ksmallest(root.right, k);
    }

    public static void main(String agrs[]) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(14);

        System.out.println("initial");
        inorder(root);

        System.out.println("\nkth smallest is : ");
        ksmallest(root, 2);
    }
}