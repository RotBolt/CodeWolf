package leetcode.may_challenge.week3;

public class MaxSumSubCircularArr {

    public static void main(String[] args) {
        int[] A = { 2, -2, 2, 7, 8, 0 };
        System.out.println(maxSubarraySumCircular(A));

    }

    // remove longest consecutive negative sums
    public static int maxSubarraySumCircular(int[] A) {
        int cMaxsum = Integer.MIN_VALUE;
        int oMaxsum = Integer.MIN_VALUE;

        int cMinSum = Integer.MAX_VALUE;
        int oMinSum = Integer.MAX_VALUE;

        int tSum = 0;

        boolean flag = true; // assuming all are -ive no. 
        for (int i = 0; i < A.length; i++) {

            if(A[i]>0)flag = false;

            tSum += A[i];

            if (cMaxsum <= 0) {
                cMaxsum = A[i];
            } else {
                cMaxsum += A[i];
            }

            if (cMaxsum > oMaxsum) {
                oMaxsum = cMaxsum;
            }

            if (cMinSum >= 0) {
                cMinSum = A[i];
            } else {
                cMinSum += A[i];
            }

            if (cMinSum < oMinSum) {
                oMinSum = cMinSum;
            }
        }

        if(flag) return oMaxsum;
        else return Math.max(tSum-oMinSum, oMaxsum);

    }

}