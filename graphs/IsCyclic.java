package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsCyclic {

    public static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                boolean res = findCyclic(graph, visited, v);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + ","));
        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();
            if (visited[rem.v]) {
                return true;
            }
            visited[rem.v] = true;
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.psf + " " + e.nbr + ","));
                }
            }
        }
        return false;
    }
}
