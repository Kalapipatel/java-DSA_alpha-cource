package Graph;

import java.util.*;

class Cycle_undirect_bfs {
    static class edge {
        int src;
        int dest;

        public edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

    }

    public static boolean iscycleutil(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        Queue<edge> q = new LinkedList<>();
        q.add(new edge(-1, src));

        while (!q.isEmpty()) {
            int node = q.peek().dest;
            int par = q.peek().src;
            q.remove();

            for (int adjnode : adj.get(node)) {
                if (!vis[adjnode]) {
                    vis[adjnode] = true;
                    q.add(new edge(node, adjnode));
                } else if (par != adjnode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (iscycleutil(i, vis, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = iscycle(4, adj);
        if (ans)
            System.out.println("yes, there is cycle");
        else
            System.out.println("no cycle");
    }
}