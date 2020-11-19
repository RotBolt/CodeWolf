package pep_coding.dp;

public class RodCutting {

    public static void main(String[] args) {
        int[] rod = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
        rodCuttingTab(rod);
        int[] store = new int[rod.length];
        System.out.println(rodCuttingMeme(rod, 8, store));
    }

    public static int rodCuttingMeme(int[] rod, int rl, int[] store) {

        if (rl == 0) {
            return 0;
        }

        if (store[rl] != 0) {
            return store[rl];
        }

        int msp = rod[rl];

        int left = 1;
        int right = rl - 1;

        while (left <= right) {
            int mspl = rodCuttingMeme(rod, left, store);
            int mspr = rodCuttingMeme(rod, right, store);
            if (mspl + mspr > msp) {
                msp = mspl + mspr;
            }

            left++;
            right--;
        }

        store[rl] = msp;
        return msp;
    }

    public static void rodCuttingTab(int[] rod) {
        int[] mp = new int[rod.length];
        String[] cut = new String[rod.length];

        mp[0] = 0;
        mp[1] = rod[1];
        cut[0] = "";
        cut[1] = "1:";

        for (int i = 2; i < rod.length; i++) {
            mp[i] = rod[i];
            cut[i] = i + ":";

            int left = 1;
            int right = i - 1;
            while (left <= right) {

                if (mp[i] < mp[left] + mp[right]) {
                    mp[i] = mp[left] + mp[right];
                    cut[i] = cut[left] + cut[right];
                }

                left++;
                right--;
            }
        }
        System.out.println(mp[rod.length - 1]);
        System.out.println(cut[rod.length - 1]);
    }

}