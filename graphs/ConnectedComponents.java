package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedComponents {
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

        System.out.println(getConnectedComponents(graph));

    }

    public static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> sub = new ArrayList<>();
                findConnectedComponents(i, graph, visited, sub);
                res.add(sub);
            }
        }
        return res;
    }

    private static void findConnectedComponents(int src, ArrayList<Edge>[] graph, boolean[] visited,
            ArrayList<Integer> sub) {
        
        // add self to component and ask to neighbours        
        visited[src] = true;
        sub.add(src);
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                findConnectedComponents(edge.nbr, graph, visited, sub);
            }
        }
    }

}
