package pep_coding.dp;

public class ClimbStairsVarJump {

    public static Integer minStepsClimb(int[] arr) {
        int n = arr.length;
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < arr[i]; j++) {
                    if (i + j < n + 1 && dp[i + j] != null) {
                        if (dp[i + j] < min) {
                            min = dp[i + j];
                        }
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }

        return dp[0];
    }

}