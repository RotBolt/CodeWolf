package dp;

public class GoldMine {
    public static void main(String[] args) {
        int[][] mine = { { 2, 6, 0, 5 }, { 0, 7, 5, 2 }, { 3, 0, 3, 7 }, { 8, 0, 2, 3 } };
        System.out.println(goldMineTab(mine));
        System.out.println(goldMineMeme(mine));
    }

    public static int goldMineTab(int[][] mine) {
        int[][] store = new int[mine.length][mine[0].length];
        String[][] path = new String[mine.length][mine[0].length];
        int max = Integer.MIN_VALUE;
        int mr = -1;
        int mc = -1;
        int lr = mine.length - 1;
        int lc = mine[0].length - 1;
        for (int c = lc; c >= 0; c--) {
            for (int r = lr; r >= 0; r--) {
                if (c == lc) {
                    store[r][c] = mine[r][c];
                    path[r][c] = "[" + r + "," + c + "]";
                } else if (r == 0) {
                    if (store[r][c + 1] > store[r + 1][c + 1]) {
                        store[r][c] = mine[r][c] + store[r][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r][c + 1];
                    } else {
                        store[r][c] = mine[r][c] + store[r + 1][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r + 1][c + 1];
                    }
                } else if (r == lr) {
                    if (store[r][c + 1] > store[r - 1][c + 1]) {
                        store[r][c] = mine[r][c] + store[r][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r][c + 1];
                    } else {
                        store[r][c] = mine[r][c] + store[r - 1][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r - 1][c + 1];
                    }
                } else {
                    if (store[r][c + 1] > store[r - 1][c + 1] && store[r][c + 1] > store[r + 1][c + 1]) {
                        store[r][c] = mine[r][c] + store[r][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r][c + 1];
                    } else if (store[r + 1][c + 1] > store[r][c + 1] && store[r + 1][c + 1] > store[r - 1][c + 1]) {
                        store[r][c] = mine[r][c] + store[r + 1][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r + 1][c + 1];
                    } else {
                        store[r][c] = mine[r][c] + store[r - 1][c + 1];
                        path[r][c] = "[" + r + "," + c + "]:" + path[r - 1][c + 1];
                    }
                }
                if (store[r][c] > max) {
                    mr = r;
                    mc = c;
                    max = store[r][c];
                }
            }
        }
        System.out.println("Max dig spot @[" + mr + "]" + "[" + mc + "] = " + store[mr][mc]);
        System.out.println(path[mr][mc]);
        return store[mr][mc];
    }

    public static int goldMineMeme(int[][] mine) {
        int[][] gcPath = new int[mine.length][mine[0].length];
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < mine.length; r++) {
            int rmax = goldMineMeme(mine, r, 0, gcPath);
            if (rmax > max) {
                max = rmax;
            }
        }
        return max;
    }

    public static int goldMineMeme(int[][] mine, int r, int c, int[][] gcPath) {
        int goldCollected = 0;
        int gcrm1 = Integer.MIN_VALUE;
        int gcr = Integer.MIN_VALUE;
        int gcrp1 = Integer.MIN_VALUE;

        if (r >= mine.length) {
            return 0;
        }

        if (c == mine[0].length - 1) {
            return mine[r][c];
        }

        if (gcPath[r][c] != 0) {
            return gcPath[r][c];
        }

        if (r > 0) {
            gcrm1 = goldMineMeme(mine, r - 1, c + 1, gcPath);
        }
        gcr = goldMineMeme(mine, r, c + 1, gcPath);
        if (r < mine.length - 1) {
            gcrp1 = goldMineMeme(mine, r + 1, c + 1, gcPath);
        }

        goldCollected = mine[r][c] + Math.max(gcr, Math.max(gcrm1, gcrp1));

        gcPath[r][c] = goldCollected;
        return goldCollected;
    }
}