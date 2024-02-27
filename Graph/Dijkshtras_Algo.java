package Graph;

import java.util.*;

public class Dijkshtras_Algo {
    static class edge {
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<edge>[] g) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        g[0].add(new edge(0, 1, 2));
        g[0].add(new edge(0, 2, 4));

        g[1].add(new edge(1, 2, 1));
        g[1].add(new edge(1, 3, 7));

        g[2].add(new edge(2, 4, 3));

        g[3].add(new edge(3, 5, 1));

        g[4].add(new edge(4, 5, 5));
        g[4].add(new edge(4, 3, 2));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int p) {
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all source to vertices shorted dist
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);

        dijkstra(graph, 0);
    }
}
