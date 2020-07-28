package leetcode.may_challenge;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int mi = c-97;
            map[mi]++;
        }
        int index = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int mi = c-97;
            if(map[mi]==1){
                index = i;
                break;
            }
        }
        return index;
    }
}