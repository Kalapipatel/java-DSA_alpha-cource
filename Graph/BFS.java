package Graph;

import java.util.*;

public class BFS {
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

    public static void bfs(ArrayList<edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); // sourcen node

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.dist);
                }
            }
        }
    }

    public static void main(String args[]) {
        int v = 7;
        ArrayList<edge> graph[] = new ArrayList[v];
        creatGraph(graph);

        bfs(graph);

    }
}
