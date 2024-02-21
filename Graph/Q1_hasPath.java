package Graph;

import java.util.ArrayList;

public class Q1_hasPath {
    static class edge {
        int srs;
        int dest;

        public edge(int s, int d) {
            this.srs = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<edge> g[]) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        g[0].add(new edge(0, 1));
        g[0].add(new edge(0, 2));

        g[1].add(new edge(1, 0));
        g[1].add(new edge(1, 3));

        g[2].add(new edge(2, 0));
        g[2].add(new edge(2, 4));

        g[3].add(new edge(3, 1));
        g[3].add(new edge(3, 4));
        g[3].add(new edge(3, 5));

        g[4].add(new edge(4, 2));
        g[4].add(new edge(4, 3));
        g[4].add(new edge(4, 5));

        g[5].add(new edge(5, 4));
        g[5].add(new edge(5, 6));

        g[6].add(new edge(6, 5));
    }

    public static boolean hasGraph(ArrayList<edge> graph[], boolean vis[], int srs, int dest) {
        if (srs == dest) {
            return true;
        }
        vis[srs] = true;
        for (int i = 0; i < graph[srs].size(); i++) {
            edge e = graph[srs].get(i);

            if (!vis[e.dest] && hasGraph(graph, vis, e.dest, dest)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[] = new ArrayList[v];

        creatGraph(graph);
        System.out.println(hasGraph(graph, new boolean[v], 0, 6));

    }
}
