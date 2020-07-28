package recursion;

public class FloodFill {

    public static void main(String[] args) {
        int[][] maze = { { 0, 1, 1 }, { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        floodFill(maze, 0, 0, "", visited);
    }

    public static void floodFill(int[][] maze, int row, int col, String psf, boolean[][] visited) {

        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
                || visited[row][col]) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        floodFill(maze, row - 1, col, psf + "t", visited);
        floodFill(maze, row, col - 1, psf + "l", visited);
        floodFill(maze, row + 1, col, psf + "d", visited);
        floodFill(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }

}