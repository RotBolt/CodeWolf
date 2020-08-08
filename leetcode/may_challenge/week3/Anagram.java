package leetcode.may_challenge.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    int MAX = 26;

    // O(N) with O(26) space
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();

        if(s.length()<p.length()){
            return list;
        }

        int[] countP = new int[MAX];
        int[] countCW = new int[MAX];

        for(int i=0;i<p.length();i++){
            countP[p.charAt(i)-'a']++;
            countCW[s.charAt(i)-'a']++;
        }
        for (int i = p.length(); i < s.length(); i++) {
            if(compare(countP, countCW)){
                list.add(i-p.length());
            }

            countCW[s.charAt(i)-'a']++;
            countCW[s.charAt(i-p.length())-'a']--;

        }
        if(compare(countP, countCW)){
            list.add(s.length()-p.length());
        }
        return list;

    }

    public boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < MAX; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // O(N(K^2)) with O(K) space
    public boolean checkAnagram(String str, int r, int n, String p) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = r; i <= n; i++) {
            Integer value = map.get(str.charAt(i));
            if (value == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), ++value);
            }
        }

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (!map.containsKey(c)) {
                return false;
            }
            Integer value = map.get(c);
            if (value == null || value == 0) {
                return false;
            }
            map.put(c, --value);
        }

        return true;
    }

}