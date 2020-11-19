package graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.IOException;

public class HamiltonianPath {
    private static class Edge {
        int src;
        int nbr;
        int weight;

        Edge(int src, int nbr, int weight) {
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            // undirected graph
            graph[v1].add(new Edge(v1, v2, weight));
            graph[v2].add(new Edge(v2, v1, weight));
        }

        int src = Integer.parseInt(br.readLine());

        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPath(graph, src, visited, src + " ", src);

    }

    private static void hamiltonianPath(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf,
            int originalSrc) {

        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            for(Edge e: graph[src]){
                if(e.nbr == originalSrc){
                    System.out.println(" *");
                    return;
                }
            }
            System.out.println(" .");
            return;
        }

        visited.add(src);
        for (Edge e : graph[src]) {
            if (!visited.contains(e.nbr)) {
                hamiltonianPath(graph, e.nbr, visited, psf + e.nbr, originalSrc);
            }
        }
        visited.remove(src);
    }
}
