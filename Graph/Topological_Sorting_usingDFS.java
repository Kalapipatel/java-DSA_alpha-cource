package Graph;

import java.util.*;

public class Topological_Sorting_usingDFS {
    static class edge {
        int src;
        int dest;

        public edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<edge>[] g) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        g[2].add(new edge(2, 3));

        g[3].add(new edge(3, 1));

        g[4].add(new edge(4, 0));
        g[4].add(new edge(4, 1));

        g[5].add(new edge(5, 0));
        g[5].add(new edge(5, 2));
    }

    public static void topSort(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<edge> g[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < g[curr].size(); i++) {
            edge e = g[curr].get(i);

            if (!vis[e.dest]) {
                topSortUtil(g, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];

        createGraph(graph);
        topSort(graph);

    }
}
