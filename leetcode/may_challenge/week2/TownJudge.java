package leetcode.may_challenge.week2;

import java.util.HashMap;

public class TownJudge {

    public static void main(String[] args) {
        int[][] trust = {{1,2}};
        System.out.println(findJudge(2, trust));

    }
    public static int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =1;i<=N;i++){
            map.put(i,0);
        }
        for (int i = 0; i < trust.length; i++) {
            int[] pair = trust[i];
            int value = map.get(pair[0]);
            map.put(pair[0], --value);

            int value1 = map.get(pair[1]);
            map.put(pair[1], ++value1);
        }

        int judge = -1;

        for(int i=1;i<=N;i++){
            int trustFactor = map.get(i);
            if(trustFactor == N-1){
                judge = i;
                break;
            }
        }

        return judge;

    }

}