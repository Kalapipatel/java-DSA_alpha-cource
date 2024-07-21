package Binary_Trees;

import java.util.*;

class boundary_order {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static void addleaf(Node root, List<Node> list) {
        if (root == null) {
            return;
        }

        if (leaf(root)) {
            list.add(root);
        }
        addleaf(root.left, list);
        addleaf(root.right, list);
    }

    public static void boundary(Node root) {
        List<Node> list = new ArrayList<>();

        left(root, list);
        addleaf(root, list);
        right(root, list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).data + " ");
        }

    }

    public static void left(Node root, List<Node> list) {
        list.add(root);
        Node curr = root.left;

        while (curr != null) {
            if (leaf(curr) == false)
                list.add(curr);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }

    }

    public static void right(Node root, List<Node> list) {
        Node curr = root.right;
        Stack<Node> s = new Stack<>();

        while (curr != null) {
            if (leaf(curr) == false)
                s.push(curr);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!s.isEmpty()) {
            list.add(s.pop());
        }

    }

    public static boolean leaf(Node root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return true;
        }

        leaf(root.left);
        leaf(root.right);

        return false;

    }

    public static void main(String args[]) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right = new Node(5);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // ---------------- new tree --------------------

        Node root2 = new Node(1);

        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.left.right = new Node(4);
        root2.left.left.right.left = new Node(5);
        root2.left.left.right.right = new Node(6);

        root2.right = new Node(7);
        root2.right.right = new Node(8);
        root2.right.right.left = new Node(9);
        root2.right.right.left.left = new Node(10);
        root2.right.right.left.right = new Node(11);

        // System.out.println(leaf(root.left.right));
        boundary(root);
        System.out.println();
        boundary(root2);

    }
}
