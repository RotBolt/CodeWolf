package leetcode.may_challenge;

import java.util.Arrays;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.isEmpty() && magazine.isEmpty()){
            return true;
        }
        int[] map = new int[26];
        for(int i=0;i<magazine.length();i++){
            map[magazine.charAt(i)-97]++;
        }

        for(int i=0;i<ransomNote.length();i++){
            int ci = ransomNote.charAt(i)-97;
            if(map[ci]<=0){
                return false;
            }else{
                map[ci]--;
            }
        }
        return true;
    }
    
}