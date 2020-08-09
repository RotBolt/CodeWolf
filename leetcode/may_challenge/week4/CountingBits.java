
package leetcode.may_challenge.week4;

public class CountingBits {

    public int[] countBits(int num) {
        
        int[] bits = new int[num + 1];
        
        if(num == 0){
            return bits;
        }
        
        bits[0] = 0;
        bits[1] = 1;

        for (int i = 2; i <= num; i++) {
            bits[i] = i % 2 + bits[i / 2];
        }
        return bits;
    }

}