package leetcode.may_challenge.week1;

public class MajorityElemet {

    
    // majority element is floor(n/2) . so majority element sab se katne ke baad bhi jinda bacha rahega

    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}