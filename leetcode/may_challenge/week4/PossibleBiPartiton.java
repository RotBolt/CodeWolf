package leetcode.may_challenge.week4;

import java.util.ArrayList;

public class PossibleBiPartiton {

    boolean[] visited;
    boolean[] group;
    boolean isGroupable = true;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // prepare graph
        for (int i = 0; i < dislikes.length; i++) {
            int[] pair = dislikes[i];
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        visited = new boolean[N + 1];
        group = new boolean[N + 1];

        for (int v = 1; v < N + 1; v++) {
            if (!visited[v])
                dfs(graph, v);
            if (!isGroupable)
                return false;
        }

        return true;
    }

    private void dfs(ArrayList<Integer>[] graph, int vertex) {
        visited[vertex] = true;
        for (int neigh : graph[vertex]) {
            if (!visited[neigh]) {
                // put neighbour in other group
                group[neigh] = !group[vertex];
                dfs(graph, neigh);
            } else if (group[vertex] == group[neigh]) {
                isGroupable = false;
                return;
            }
        }
    }

}