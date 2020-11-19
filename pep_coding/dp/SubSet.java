package pep_coding.dp;

import java.util.Arrays;

public class SubSet {

    public static void main(String[] args) {
        System.out.println(isSubSetProblem(30, new int[] { 3, 34, 4, 12, 5, 2 }));
    }

    public static boolean isSubSetProblem(int targetSum, int[] set) {
        Arrays.sort(set);
        int left = 0;
        int right = set.length - 1;
        boolean found = false;
        while (left < right) {
            int sum = set[left] + set[right];
            if (sum == targetSum) {
                System.out.println("Set [" + set[left] + ", " + set[right] + "] = " + targetSum);
                found = true;
                break;
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return found;
    }

    public static boolean isSubSet(int target, int[] arr) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    // curr element is greater then the sum required
                    if (arr[i - 1] > j) {
                        // take result from previous set. Hence not included
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // curr element included
                        int res = j - arr[i - 1];
                        if (res >= 0) {
                            // take rest of result from previous set
                            dp[i][j] = dp[i - 1][res];
                        }
                    }
                }
            }
        }
        return dp[arr.length][target];
    }

}