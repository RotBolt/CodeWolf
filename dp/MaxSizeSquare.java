package dp;

public class MaxSizeSquare {

    public static void main(String[] args) {
        int[][] arr = { 
            { 1, 0, 1, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 0 },
            { 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 1, 0 }
        };

        maxSizeSquareTab(arr);

        int[][] storage = new int[arr.length][arr[0].length];
        maxSizeSquareMeme(arr, 0, 0, arr.length - 1, arr[0].length - 1, storage);
        System.out.println(oMax + "@" + "[" + omr + "]" + "[" + omc + "]");
    }

    public static int maxSizeSquareTab(int[][] arr) {
        int[][] mss = new int[arr.length][arr[0].length];

        int lr = arr.length - 1;
        int lc = arr[0].length - 1;

        int msr = lr;
        int msc = lc;
        for (int r = lr; r >= 0; r--) {
            for (int c = lc; c >= 0; c--) {
                if (arr[r][c] == 0) {
                    mss[r][c] = 0;
                } else if (r == lr || c == lc) {
                    mss[r][c] = arr[r][c];
                } else {
                    mss[r][c] = Math.min(mss[r + 1][c + 1], Math.min(mss[r][c + 1], mss[r + 1][c])) + 1;
                }
                if (mss[r][c] > mss[msr][msc]) {
                    msc = c;
                    msr = r;
                }
            }
        }

        System.out.println(mss[msr][msc] + "@[" + msr + "]" + "[" + msc + "]");
        return mss[msr][msc];

    }

    static int oMax = 0;
    static int omr = -1;
    static int omc = -1;

    public static int maxSizeSquareMeme(int[][] arr, int sr, int sc, int dr, int dc, int[][] storage) {

        if (sr == dr || sc == dc) {
            return arr[sr][dc];
        }

        if (arr[sr][sc] == 0) {
            return 0;
        }

        if (storage[sr][sc] != 0) {
            return storage[sr][sc];
        }

        int mvs = maxSizeSquareMeme(arr, sr + 1, sc, dr, dc, storage);
        int mhs = maxSizeSquareMeme(arr, sr, sc + 1, dr, dc, storage);
        int mds = maxSizeSquareMeme(arr, sr + 1, sc + 1, dr, dc, storage);

        int ms = 1 + Math.min(mds, Math.min(mvs, mhs));

        storage[sr][sc] = ms;

        if (ms > oMax) {
            oMax = ms;
            omr = sr;
            omc = sc;
        }

        return ms;

    }

}