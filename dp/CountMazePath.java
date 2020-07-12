package dp;

import java.util.Arrays;

public class CountMazePath {

    public static void main(String[] args) {
        int num = 15;
        System.out.println(countMazePathMeme(0, 0, num, num, new int[num + 1][num + 1]));
        System.out.println(countMazePathTab(num, num));
        System.out.println(countMazePathSlider(num, num));
    }

    public static int countMazePathSlider(int dr, int dc) {
        int[] slider = new int[dc + 1];

        Arrays.fill(slider, 1);
        for (int nors = 1; nors <= dr; nors++) {
            for (int c = slider.length - 2; c >= 0; c--) {
                int nv = slider[c] + slider[c + 1];
                slider[c] = nv;
            }
        }
        return slider[0];
    }

    public static int countMazePathTab(int dr, int dc) {
        int[][] f = new int[dr + 1][dc + 1];
        f[dr][dc] = 1;
        for (int x = dr; x >= 0; x--) {
            for (int y = dc; y >= 0; y--) {
                if (x == dr && y == dc) {
                    // last cell
                    f[x][y] = 1;
                } else if (x == dr) {
                    // last row
                    f[x][y] = f[x][y + 1];
                } else if (y == dc) {
                    // last col
                    f[x][y] = f[x + 1][y];
                } else {
                    f[x][y] += f[x][y + 1] + f[x + 1][y];
                }
            }
        }

        return f[0][0];
    }

    public static int countMazePathMeme(int sr, int sc, int dr, int dc, int[][] store) {

        if (sr == dr && sc == dc) {
            return 1;
        }

        if (sc > dc || sr > dr) {
            return 0;
        }

        if (store[sr][sc] != 0) {
            return store[sr][sc];
        }

        int count = 0;

        int inter1 = countMazePathMeme(sr, sc + 1, dr, dc, store);
        int inter2 = countMazePathMeme(sr + 1, sc, dr, dc, store);

        count += inter1 + inter2;

        store[sr][sc] = count;

        return count;

    }

    public static int countMazePath(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            return 1;
        }

        if (sc > dc && sr > dr) {
            return 0;
        }

        int count = 0;

        int inter1 = countMazePath(sr, sc + 1, dr, dc);
        int inter2 = countMazePath(sr + 1, sc, dr, dc);

        count += inter1 + inter2;

        return count;

    }

}