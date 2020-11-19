package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadInfection {

    public static class Pair {
        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

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

        int src = Integer.parseInt(br.readLine());
        spreadInfection(graph, src);

    }

    public static int spreadInfection(ArrayList<Edge>[] graph, int src) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));
        int[] infected = new int[graph.length]; // 0 means not infected. 
        int count = 0;
        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();

            if (infected[rem.v] == 0) {
                infected[rem.v] = rem.time;
                count++;

                for (Edge e : graph[rem.v]) {
                    if (infected[e.nbr] == 0) {
                        q.add(new Pair(e.nbr, rem.time + 1));
                    }
                }
            }
        }
        return count;
    }

}
