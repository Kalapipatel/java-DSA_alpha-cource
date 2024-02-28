package Graph;

import java.util.*;

public class BellmanFord_algo {
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

        g[1].add(new edge(1, 2, -4));

        g[2].add(new edge(2, 3, 2));

        g[3].add(new edge(3, 4, 4));

        g[4].add(new edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;

        // algo
        for (int i = 0; i < V - 1; i++) {
            // edge -> O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    edge e = graph[j].get(k);
                    // u,v,wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxtion
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);

        bellmanFord(graph, 0);
    }
}
