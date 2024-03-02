package Graph;

import java.util.*;

public class Prims_algo {
    static class edge {
        int srs;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.srs = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void creatGraph(ArrayList<edge> g[]) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        g[0].add(new edge(0, 1, 10));
        g[0].add(new edge(0, 2, 15));
        g[0].add(new edge(0, 3, 30));

        g[1].add(new edge(1, 0, 10));
        g[1].add(new edge(1, 3, 40));

        g[2].add(new edge(2, 0, 15));
        g[2].add(new edge(2, 3, 50));

        g[3].add(new edge(3, 1, 40));
        g[3].add(new edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("finalCost is : " + finalCost);
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 4;
        ArrayList<edge> graph[] = new ArrayList[v];
        creatGraph(graph);

        prims(graph);
    }
}
