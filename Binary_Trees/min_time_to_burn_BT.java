package Binary_Trees;

import java.util.*;

public class min_time_to_burn_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static Node parent_mapping(Node root, int start, HashMap<Node, Node> map) {
        Node s = new Node(-1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.data == start) {
                s = curr;
            }

            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return s;
    }

    public static int findTime(HashMap<Node, Node> map, Node start) {
        int maxi = 0;
        HashMap<Node, Integer> vis = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        vis.put(start, 1);

        while (!q.isEmpty()) {
            int size = q.size();
            int fl = 0;

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                if (curr.left != null && vis.get(curr.left) == null) {
                    q.add(curr.left);
                    vis.put(curr.left, 1);
                    fl = 1;
                }
                if (curr.right != null && vis.get(curr.right) == null) {
                    q.add(curr.right);
                    vis.put(curr.right, 1);
                    fl = 1;
                }

                if (map.get(curr) != null && vis.get(map.get(curr)) == null) {
                    q.add(map.get(curr));
                    vis.put(map.get(curr), 1);
                    fl = 1;
                }
            }

            if (fl == 1)
                maxi++;
        }

        return maxi;
    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        HashMap<Node, Node> map = new HashMap<>();
        Node start = parent_mapping(root, 6, map);
        int maxi = findTime(map, start);

        System.out.println(maxi); // 4

    }
}
