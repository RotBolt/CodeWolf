package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Minimum spanning tree
public class Prims {

    public class Edge {
        int src;
        int nbr;
        int weight;

        public Edge(int src, int nbr, int weight) {
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    public class Pair implements Comparable<Pair> {
        int vtx;
        int p;
        int wt;

        public Pair(int vtx, int p, int wt) {
            this.vtx = vtx;
            this.p = p;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public void prims(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, -1, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();
            if (!visited[rem.vtx]) {
                visited[rem.vtx] = true;
                if (rem.p != -1) {
                    System.out.println(rem.vtx + "-" + rem.p + "@" + rem.wt);
                }
                for (Edge e : graph[rem.vtx]) {
                    if (!visited[e.nbr]) {
                        pq.add(new Pair(e.nbr, e.src, e.weight));
                    }
                }
            }
        }
    }
}