package pep_coding.dp;

public class CountBP {

    public static void main(String[] args) {
        int dest = 30;
        int[] store = new int[dest + 1];
        System.out.println(countBoardPathSlider(dest));
        System.out.println(countBoardPath(0, dest));
        System.out.println(countBoardPathMeme(0, dest, store));
        System.out.println(countBoardPathTab(dest));
    }

    public static int countBoardPathSlider(int dest) {
        int[] s = new int[6];

        s[0] = 1;
        for (int nos = 1; nos <= dest; nos++) {
            int nv = s[0] + s[1] + s[2] + s[3] + s[4] + s[5];
            s[5] = s[4];
            s[4] = s[3];
            s[3] = s[2];
            s[2] = s[1];
            s[1] = s[0];
            s[0] = nv;
        }

        return s[0];
    }

    public static int countBoardPath(int src, int dest) {
        if (src > dest) {
            return 0;
        }

        if (src == dest) {
            return 1;
        }

        int count = 0;
        for (int dice = 1; dice <= 6; dice++) {
            int step = dice + src;
            int interCount = countBoardPath(step, dest);
            count += interCount;

        }
        return count;
    }

    public static int countBoardPathMeme(int src, int dest, int[] store) {
        if (src > dest) {
            return 0;
        }

        if (store[src] != 0) {
            return store[src];
        }

        if (src == dest) {
            return 1;
        }

        int count = 0;
        for (int dice = 1; dice <= 6; dice++) {
            int step = dice + src;
            int interCount = countBoardPathMeme(step, dest, store);
            count += interCount;
        }
        store[src] = count;
        return count;
    }

    public static int countBoardPathTab(int dest) {
        int[] f = new int[dest + 1];
        f[dest] = 1;
        for (int x = dest - 1; x >= 0; x--) {
            for (int dice = 1; dice <= 6; dice++) {
                if (x + dice <= dest) {
                    f[x] += f[x + dice];
                }
            }
        }
        return f[0];
    }

}