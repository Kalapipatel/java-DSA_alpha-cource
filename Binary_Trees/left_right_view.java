package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class left_right_view {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize
        // the node with a value
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static List<Integer> rightsideView(Node root) {
        List<Integer> res = new ArrayList<>();

        recursionRight(root, 0, res);

        return res;
    }

    public static List<Integer> leftsideView(Node root) {
        List<Integer> res = new ArrayList<>();

        recursionLeft(root, 0, res);

        return res;
    }

    public static void recursionLeft(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.data);
        }

        recursionLeft(root.left, level + 1, res);

        recursionLeft(root.right, level + 1, res);
    }

    public static void recursionRight(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);

            recursionRight(root.right, level + 1, res);
            recursionRight(root.left, level + 1, res);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Get the Right View traversal
        List<Integer> rightView = rightsideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the Left View traversal
        List<Integer> leftView = leftsideView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}