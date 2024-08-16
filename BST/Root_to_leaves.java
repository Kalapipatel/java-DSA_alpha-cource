package BST;

import java.util.ArrayList;

public class Root_to_leaves {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;

        path.add(root.data);
        if (root.left == null && root.right == null) {
            print(path);
            System.out.println();
        }

        root2Leaf(root.left, path);
        root2Leaf(root.right, path);

        path.remove(path.size() - 1);
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

        ArrayList<Integer> ans = new ArrayList<>();
        root2Leaf(root, ans);
    }
}
