package Binary_Trees;

import java.util.*;

public class Maximum_Width {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class pair {
        TreeNode node;
        int num;

        pair(TreeNode no, int nu) {
            this.node = no;
            this.num = nu;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<pair> q = new LinkedList<>();
        int ans = 0;

        q.add(new pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int curr = q.peek().num - min;
                q.poll();

                if (i == 0)
                    first = curr;
                if (i == size - 1)
                    last = curr;

                if (node.left != null) {
                    q.add(new pair(node.left, curr * 2 + 1));
                }
                if (node.right != null) {
                    q.add(new pair(node.right, curr * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(widthOfBinaryTree(root)); // 4
    }

}
