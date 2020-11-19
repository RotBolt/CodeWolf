package pep_coding.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphBiPartitie {

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

    public static class Pair {
        int v;
        String psf;
        int level;

        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    // Even length cycle and acyclic pep_coding.graphs are bi partite
    // Odd length cycle are non-bi partite
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int[] visited = new int[graph.length]; // visited stores the level of tree. -1 denotes node is not visted else
                                               // level of node
        Arrays.fill(visited, -1);
        for (int v = 0; v < graph.length; v++) {
            boolean res = checkComponentBiPartite(graph, visited, v);
            if (!res) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkComponentBiPartite(ArrayList<Edge>[] graph, int[] visited, int src) {
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        Pair orig = new Pair(src, src + ", ", 0);
        q.add(orig);
        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();
            if (visited[rem.v] != -1) {
                // odd length cycle. Vertex is accessible at different levels in more than one way.
                // Even length cycle , Vertex is accessible  at same level in more than one ways
                if (visited[rem.v] != rem.level) {
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr + ", ", rem.level + 1));
                }
            }
        }
        return true;
    }

}
