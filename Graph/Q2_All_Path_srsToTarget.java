package Graph;

import java.util.ArrayList;

public class Q2_All_Path_srsToTarget {

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
        g[0].add(new edge(0, 3));

        g[2].add(new edge(2, 3));

        g[3].add(new edge(3, 1));

        g[4].add(new edge(4, 0));
        g[4].add(new edge(4, 1));

        g[5].add(new edge(5, 0));
        g[5].add(new edge(5, 2));
    }

    public static void printAllPath(ArrayList<edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);

        printAllPath(graph, 5, 1, "");
    }

}
