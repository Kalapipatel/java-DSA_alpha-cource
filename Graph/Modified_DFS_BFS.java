package Graph;

import java.util.*;

public class Modified_DFS_BFS {
    static class edge {
        int srs;
        int dist;

        public edge(int s, int d) {
            this.srs = s;
            this.dist = d;
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

    public static void bfs(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<edge> graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // sourcen node

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.dist);
                }
            }
        }
    }

    public static void dfs(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<edge> graph[], int curr, boolean vis[]) {
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dist]) {
                dfsUtil(graph, e.dist, vis);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 7;
        ArrayList<edge> graph[] = new ArrayList[v];
        creatGraph(graph);

        bfs(graph);
        System.out.println();
        dfs(graph);
    }
}
