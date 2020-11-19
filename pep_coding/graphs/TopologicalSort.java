package pep_coding.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static class Edge {
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

        topologicalSort(graph);

    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> topoStack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortHelper(graph, i, topoStack, visited);
            }
        }
        while (!topoStack.isEmpty()) {
            System.out.print(topoStack.pop() + ", ");
        }
    }

    private static void topologicalSortHelper(ArrayList<Edge>[] graph, int src, Stack<Integer> topoStack,
            boolean[] visited) {

        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                topologicalSortHelper(graph, e.nbr, topoStack, visited);
            }
        }
        topoStack.push(src);
    }

}
