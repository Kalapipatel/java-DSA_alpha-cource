package Graph;

import java.util.*;

public class Topological_Sorting_usingBFS {
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

    public static void calcIndeg(ArrayList<edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);

                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];

        createGraph(graph);
        topSort(graph);

    }
}
