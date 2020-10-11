package graphs;

public class NoOfIslands {

    public static void noOfIslands(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    drawTreeForComponent(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("Count is " + count);
    }

    public static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {
        if (arr[i][j] == 1) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length) {
            return;
        }

        visited[i][j] = true;
        drawTreeForComponent(arr, i + 1, j, visited);
        drawTreeForComponent(arr, i, j + 1, visited);
        drawTreeForComponent(arr, i - 1, j, visited);
        drawTreeForComponent(arr, i, j - 1, visited);
    }

}