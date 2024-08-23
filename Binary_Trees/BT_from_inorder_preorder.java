package Binary_Trees;

import java.util.HashMap;

public class BT_from_inorder_preorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static Node buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;
    }

    public static Node helper(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd,
            HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preorder[preStart]);

        int rootidx = map.get(root.data);
        int numleft = rootidx - inStart;

        root.left = helper(preorder, preStart + 1, preStart + 1 + numleft, inorder, inStart, rootidx - 1, map);

        root.right = helper(preorder, preStart + 1 + numleft, preEnd, inorder, rootidx + 1, inEnd, map);

        return root;
    }

    public static void printinorder(Node root) {
        if (root == null)
            return;

        printinorder(root.left);
        System.out.print(root.data + " ");
        printinorder(root.right);
    }

    public static void main(String[] args) {
        int inorder[] = { 9, 3, 15, 20, 7 };
        int preorder[] = { 3, 9, 20, 15, 7 };

        Node root = buildTree(inorder, preorder);
        printinorder(root);
    }
}
