package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstra {

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

    public static class Pair implements Comparable<Pair> {
        int vtx;
        String psf;
        int wsf;

        public Pair(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void shortestPath(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        pq.add(new Pair(src, src + ", ", 0));
        while (!pq.isEmpty()) {
            Pair rm = pq.poll();

            if (!visited[rm.vtx]) {
                visited[rm.vtx] = true;
                System.out.println(rm.vtx + " via " + rm.psf + "@" + rm.wsf);
                for (Edge e : graph[rm.vtx]) {
                    if (!visited[e.nbr]) {
                        pq.add(new Pair(e.nbr, rm.psf + e.nbr, rm.wsf + e.weight));
                    }
                }
            }
        }
    }

}