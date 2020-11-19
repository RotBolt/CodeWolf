package pep_coding.dp;

public class MinPallinCut {
    public static void main(String[] args) {
        String str = "abccbc";
        System.out.println(minPallinCutMeme(str, 0, str.length() - 1, new int[str.length()][str.length()]));
        System.out.println(minPallinCutTab(str));
    }

    public static int minPallinCutMeme(String str, int si, int ei, int[][] store) {

        if (store[si][ei] != 0) {
            return store[si][ei];
        }

        if (isPallin(str, si, ei) == true) {
            return 0;
        }

        int mpc = Integer.MAX_VALUE;

        for (int cp = si; cp < ei; cp++) {
            int mpcss1 = minPallinCutMeme(str, si, cp, store);
            int mpcss2 = minPallinCutMeme(str, cp + 1, ei, store);

            int tota = mpcss1 + mpcss2 + 1;
            if (tota < mpc) {
                mpc = tota;
            }
        }

        store[si][ei] = mpc;
        return mpc;

    }

    public static int minPallinCutTab(String str) {
        boolean[][] pallinRes = new boolean[str.length()][str.length()];

        for (int dia = 0; dia < str.length(); dia++) {
            int si = 0;
            int ei = dia;

            while (ei < str.length()) {
                if (dia == 0) {
                    pallinRes[si][ei] = true;
                } else if (dia == 1) {
                    pallinRes[si][ei] = str.charAt(si) == str.charAt(ei);
                } else {
                    pallinRes[si][ei] = (str.charAt(si) == str.charAt(ei)) && (pallinRes[si + 1][ei - 1]);
                }
                ei++;
                si++;
            }
        }

        int[][] mpc = new int[str.length()][str.length()];
        for (int dia = 0; dia < str.length(); dia++) {
            int si = 0;
            int ei = dia;

            while (ei < str.length()) {
                if (dia == 0) {
                    mpc[si][ei] = 0;
                } else if (dia == 1) {
                    mpc[si][ei] = pallinRes[si][ei] ? 0 : 1;
                } else {
                    if (pallinRes[si][ei]) {
                        mpc[si][ei] = 0;
                        ei++;
                        si++;
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    for (int cp = si; cp < ei; cp++) {
                        int fp = mpc[si][cp];
                        int sp = mpc[cp + 1][ei];

                        int factor = fp + sp + 1;
                        if (factor < min) {
                            min = factor;
                        }

                    }
                    mpc[si][ei] = min;
                }
                ei++;
                si++;
            }
        }
        return mpc[0][str.length() - 1];
    }

    private static boolean isPallin(String str, int si, int ei) {

        while (si < ei) {

            if (str.charAt(si) != str.charAt(ei)) {
                return false;
            }

            si++;
            ei--;
        }

        return true;
    }
}