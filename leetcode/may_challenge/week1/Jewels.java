package leetcode.may_challenge.week1;

public class Jewels {

    public int numJewelsInStones(String J, String S) {
        int c=0;
        for(int i=0; i<S.length();i++){
            char stone = S.charAt(i);
            char[] str = {stone};
            String st = new String(str);
            J.contains(st);
            if(J.indexOf(S.charAt(i)) != -1)
                c++;
        }
            return c;
    }
    
}