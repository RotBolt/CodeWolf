package pep_coding.dp;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] costs = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };
        int[][] store = new int[costs.length][costs[0].length];
        System.out.println(minCostPathMeme(0, 0, costs.length - 1, costs[0].length - 1, costs, store));
        System.out.println(minCostPathTab(costs));
    }

    public static int minCostPathTab(int[][] costs) {

        int[][] mcosts = new int[costs.length][costs[0].length];
        String[][] path = new String[costs.length][costs[0].length];

        int dr = costs.length - 1;
        int dc = costs[0].length - 1;

        for (int r = dr; r >= 0; r--) {
            for (int c = dc; c >= 0; c--) {
                if (r == dr && c == dc) {
                    mcosts[r][c] = costs[r][c];
                    path[r][c] = ".";
                } else if (r == dr) {
                    mcosts[r][c] = costs[r][c] + mcosts[r][c + 1];
                    path[r][c] = "H" + path[r][c + 1];
                } else if (c == dc) {
                    mcosts[r][c] = costs[r][c] + mcosts[r + 1][c];
                    path[r][c] = "V" + path[r + 1][c];
                } else {
                    if (mcosts[r][c + 1] > mcosts[r + 1][c]) {
                        mcosts[r][c] = costs[r][c] + mcosts[r + 1][c];
                        path[r][c] = "V" + path[r + 1][c];
                    } else {
                        mcosts[r][c] = costs[r][c] + mcosts[r][c + 1];
                        path[r][c] = "H" + path[r][c + 1];
                    }
                }
            }
        }

        System.out.println(path[0][0]);
        return mcosts[0][0];

    }

    public static int minCostPath(int sr, int sc, int dr, int dc, int[][] costs) {

        if (sr == dr && sc == dc) {
            return costs[dr][dc];
        }

        int mcstod = 0;
        int mcivtod = Integer.MAX_VALUE;
        int mcihtod = Integer.MAX_VALUE;

        if (sr < dr) {
            mcivtod = minCostPath(sr + 1, sc, dr, dc, costs);
        }

        if (sc < dc) {
            mcihtod = minCostPath(sr, sc + 1, dr, dc, costs);
        }

        mcstod = costs[sr][sc] + Math.min(mcihtod, mcivtod);

        return mcstod;

    }

    public static int minCostPathMeme(int sr, int sc, int dr, int dc, int[][] costs, int[][] store) {

        if (sr == dr && sc == dc) {
            return costs[dr][dc];
        }

        if (store[sr][sc] != 0) {
            return store[sr][sc];
        }

        int mcstod = 0;
        int mcivtod = Integer.MAX_VALUE;
        int mcihtod = Integer.MAX_VALUE;

        if (sr < dr) {
            mcivtod = minCostPathMeme(sr + 1, sc, dr, dc, costs, store);
        }

        if (sc < dc) {
            mcihtod = minCostPathMeme(sr, sc + 1, dr, dc, costs, store);
        }

        mcstod = costs[sr][sc] + Math.min(mcihtod, mcivtod);
        store[sr][sc] = mcstod;

        return mcstod;

    }
}