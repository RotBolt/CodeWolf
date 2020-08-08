package leetcode.may_challenge.week3;

public class Permutation {

    // Find permutation of String S1 in String S2

    int max = 26;

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] countP = new int[max];
        int[] countW = new int[max];

        for (int i = 0; i < s1.length(); i++) {
            countP[s1.charAt(i) - 'a']++;
            countW[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (compare(countP, countW)) {
                return true;
            }
            countW[s2.charAt(i) - 'a']++;
            countW[s2.charAt(i - s1.length()) - 'a']--;
        }
        if (compare(countP, countW)) {
            return true;
        }
        return false;
    }

    public boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < max; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}