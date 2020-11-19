package pep_coding.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {

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

    private static class Pair {
        int v;
        String psf;

        Pair(int vertice, String psf) {
            this.v = v;
            this.psf = psf;
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

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + " "));
        boolean[] visited = new boolean[vertices];
        while (!queue.isEmpty()) {
            // r m* w a*
            Pair rem = queue.poll();
            if (!visited[rem.v]) {
                visited[rem.v] = true;
                System.out.println(rem.v + "@" + rem.psf);
                for (Edge e : graph[rem.v]) {
                    if (!visited[e.nbr]) {
                        queue.add(new Pair(e.nbr, rem.psf + " " + e.nbr));
                    }
                }
            }
        }
    }

}