package leetcode.may_challenge.week5;

import java.util.ArrayList;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = prepareGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] currPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(graph, i, visited, currPath)) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer>[] prepareGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            graph[edge[0]].add(edge[1]);
        }

        return graph;

    }

    private static boolean isCyclic(ArrayList<Integer>[] graph, int v, boolean[] visited, boolean[] currPath) {
        // if already occured in current path traversal then its cycle
        if (currPath[v]) {
            return true;
        }

        // visited by some other node path traversal but not in current path traversal
        if (visited[v]) {
            return false;
        }

        currPath[v] = true;
        visited[v] = true;

        for (int neighbour : graph[v]) {
            if (isCyclic(graph, neighbour, visited, currPath)) {
                return true;
            }
        }

        // no cycle detected. back tracking . removing from current path traversal
        currPath[v] = false;
        return false;

    }

}