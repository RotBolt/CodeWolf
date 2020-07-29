package leetcode.may_challenge.week2;

public class PerfectSquare {
    // O(sqrt(n))
    // public static boolean isPerfectSquare(int num) {
    //     for (int i = 1; i * i <= num; i++) {
    //         if(i*i == num){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // O(logN)

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;
        long low = 1,high = num/2; //do it with long instead of int
        while(low<=high){
            long mid = (low+high)/2;
            if(mid*mid == num)
                return true;
            else if(mid*mid < num)
                low = mid+1;
            else if(mid*mid > num)
                high = mid-1;
        }
        return false;
    }

    
}