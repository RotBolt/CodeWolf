package dp;

import java.util.HashMap;

public class UglyNumbers {

    public static void main(String[] args) {
        System.out.println(getUglyNumberBetter(150));
    }

    // Time Complexity is Linear but still > O(n) also Space Complexity > O(n)
    public static int getUglyNumber(int num) {
        HashMap<Integer, Boolean> uglyMap = new HashMap<>();
        uglyMap.put(1, true);
        int count = 2;
        int ans = 1;
        for (int i = 2; count < num + 1; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                int factor;
                if (i % 2 == 0) {
                    factor = i / 2;
                } else if (i % 3 == 0) {
                    factor = i / 3;
                } else {
                    factor = i / 5;
                }
                if (uglyMap.containsKey(factor) && uglyMap.get(factor)) {
                    uglyMap.put(i, true);
                    count++;
                    ans = i;
                } else {
                    uglyMap.put(i, false);
                }
            } else {
                uglyMap.put(i, false);
            }
        }
        return ans;
    }

    public static int getUglyNumberBetter(int num) {
        int[] ugly = new int[num];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int nextMultiple2 = 2;
        int nextMultiple3 = 3;
        int nextMultiple5 = 5;

        ugly[0] = 1;

        int nextUgly = 1;

        for (int i = 1; i < num; i++) {
            nextUgly = Math.min(nextMultiple2, Math.min(nextMultiple3, nextMultiple5));
            ugly[i] = nextUgly;
            if (nextUgly == nextMultiple2) {
                i2 += 1;
                nextMultiple2 = ugly[i2] * 2;
            }
            if (nextUgly == nextMultiple3) {
                i3 += 1;
                nextMultiple3 = ugly[i3] * 3;
            }
            if (nextUgly == nextMultiple5) {
                i5 += 1;
                nextMultiple5 = ugly[i5] * 5;
            }
        }
        return nextUgly;
    }
}