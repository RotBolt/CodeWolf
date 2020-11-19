package pep_coding.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MultiSolver {

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

    // otherwise need to create object of MultiSolver class
    // new MultiSolver().new Pair()
    public static class Pair implements Comparable<Pair>{
        String path;
        int weight;

        Pair(String path,int weight){
            this.path = path;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        
    }

    /**
     * 7 
     * 8 
     * 0 1 10 
     * 1 2 10 
     * 2 3 10 
     * 0 3 40 
     * 3 4 2 
     * 4 5 3 
     * 5 6 3 
     * 4 6 8 
     * 0 
     * 6 
     * 40 
     * 3
     */

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
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vertices];

    }

    static String sPath;
    static int sWeight = Integer.MAX_VALUE;
    
    static String lPath;
    static int lWeight= Integer.MIN_VALUE;

    static String cPath;
    static int cWeight = Integer.MAX_VALUE;

    static String fPath;
    static int fWeight = Integer.MIN_VALUE;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
            String psf, int wsf) {

        if (src == dest) {
            if(wsf < sWeight){
                sPath = psf;
                sWeight = wsf;
            }

            if(wsf > lWeight){
                lPath = psf;
                lWeight = wsf;
            }

            if(wsf > criteria && wsf < cWeight){
                cPath = psf;
                cWeight = wsf;
            }

            if(wsf < criteria && wsf > fWeight){
                fPath = psf;
                fWeight = wsf;
            }

            if(pq.size() < k){
                pq.add(new Pair(psf, wsf));
            }else if(wsf > pq.peek().weight){
                pq.remove();
                pq.add(new Pair(psf, wsf));
            }


            return;
        }

        visited[src] = true;

        // ask to all neighbours
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.weight);
            }
        }

        visited[src] = false;

    }

}
