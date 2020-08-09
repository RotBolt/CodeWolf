package leetcode.may_challenge.week4;

import java.util.ArrayList;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        ArrayList<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int[] apair = A[i];
            for (int j = 0; j < B.length; j++) {
                int[] bpair = B[j];
                int[] ansPair = new int[2];
                ansPair[0] = Integer.MIN_VALUE;
                ansPair[1] = Integer.MIN_VALUE;

                if (apair[0] >= bpair[0] && apair[0] <= bpair[1]) {
                    ansPair[0] = apair[0];
                } else if (bpair[0] >= apair[0] && bpair[0] <= apair[1]) {
                    ansPair[0] = bpair[0];
                }

                if (apair[1] >= bpair[0] && apair[1] <= bpair[1]) {
                    ansPair[1] = apair[1];
                } else if (bpair[1] >= apair[0] && bpair[1] <= apair[1]) {
                    ansPair[1] = bpair[1];
                }

                if (ansPair[0] != Integer.MIN_VALUE && ansPair[1] != Integer.MIN_VALUE) {
                    ansList.add(ansPair);
                }

            }
        }
        int[][] ans = new int[ansList.size()][2];

        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

}