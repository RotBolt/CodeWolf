package leetcode.dynamic_programming;

public class EditDistance {

     // Time complexity O(mXn) space O(mXn)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                // first string is empty . insert all characters from second string
                if (i == 0) {
                    dp[i][j] = j;
                }
                // second string is empty. remove all characters.
                else if (j == 0) {
                    dp[i][j] = i;
                }

                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else {
                    dp[i][j] = 1 + Math.min(
                            // replace
                            dp[i - 1][j - 1],
                            // insert and remove
                            Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[m][n];
    }

    // Time complexity O(mXn) space O(m)
    public int editDistanceSW(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[2][m + 1];

        // base condition when second string is empty
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int j = 1; j < n + 1; j++) {
            for (int i = 0; i < m + 1; i++) {
                if (i == 0) {
                    dp[j % 2][i] = j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j % 2][i] = dp[(j - 1) % 2][i - 1];
                } else {
                    dp[j % 2][i] = 1 + Math.min(dp[(j - 1) % 2][i - 1], Math.min(dp[j % 2][i - 1], dp[(j - 1) % 2][i]));
                }
            }
        }
        return dp[n % 2][m];
    }

}