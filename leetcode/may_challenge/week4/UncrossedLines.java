package leetcode.may_challenge.week4;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // if match, represents A[i-1],A[i-2]..... B[j-1][j-2]...
                if(A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                // take best of A[i-1][i-2]... and B[j-1][j-2].....
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
    }

}