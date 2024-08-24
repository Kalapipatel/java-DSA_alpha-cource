package Binary_Trees;

import java.util.HashMap;

public class BT_from_inorder_Postorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static Node buildtree(int inorder[], int postorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Node root = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

        return root;
    }

    public static Node helper(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd,
            HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        Node root = new Node(postorder[postEnd]);

        int rootidx = map.get(postorder[postEnd]);
        int numleft = rootidx - inStart;

        root.left = helper(inorder, inStart, rootidx - 1, postorder, postStart, postStart + numleft - 1, map);
        root.right = helper(inorder, rootidx + 1, inEnd, postorder, postStart + numleft, postEnd - 1, map);

        return root;
    }

    public static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String args[]) {

        int inorder[] = { 40, 20, 50, 10, 60, 30 };
        int postorder[] = { 40, 50, 20, 60, 30, 10 };

        Node root = buildtree(inorder, postorder);
        printInorder(root);

    }
}
