package leetcode.may_challenge.week4;

import java.util.HashMap;

public class ContiguosSubArr {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int count = 0;
        int maxLength = 0;
        counts.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (counts.containsKey(count)) {
                int subArrLength = i - counts.get(count);
                maxLength = Math.max(maxLength, subArrLength);
            } else {
                counts.put(count, i);
            }
        }
        return maxLength;
    }

}