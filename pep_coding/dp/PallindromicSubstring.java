package pep_coding.dp;

public class PallindromicSubstring {

    public static void main(String[] args) {
        System.out.println(countPallinSS("abccbc"));
    }

    public static int countPallinSS(String str) {
        boolean[][] strg = new boolean[str.length()][str.length()];
        int count = 0;
        for (int dia = 0; dia < str.length(); dia++) {
            int si = 0;
            int ei = dia;

            while (ei < str.length()) {

                if (dia == 0) {
                    strg[si][ei] = true;
                } else if (dia == 1) {
                    strg[si][ei] = str.charAt(si) == str.charAt(ei);
                } else if (str.charAt(si) == str.charAt(ei) && strg[si + 1][ei - 1] == true) {
                    strg[si][ei] = true;
                }

                if (strg[si][ei] == true) {
                    count++;
                }

                ei++;
                si++;
            }
        }
        return count;
    }

}