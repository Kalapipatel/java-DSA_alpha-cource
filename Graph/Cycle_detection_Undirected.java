package Graph;

import java.util.*;

public class Cycle_detection_Undirected {
    static class edge {
        int src;
        int dest;

        public edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<edge> g[]) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        g[0].add(new edge(0, 1));
        g[0].add(new edge(0, 2));
        g[0].add(new edge(0, 3));

        g[1].add(new edge(1, 0));
        g[1].add(new edge(1, 2));

        g[2].add(new edge(2, 0));
        g[2].add(new edge(2, 1));

        g[3].add(new edge(3, 0));
        g[3].add(new edge(3, 4));

        g[4].add(new edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exists is one of the path
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing -> continue

        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        creatGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
