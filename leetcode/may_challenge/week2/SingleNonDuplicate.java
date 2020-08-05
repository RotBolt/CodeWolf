package leetcode.may_challenge.week2;

public class SingleNonDuplicate {
    
    // array is always odd in length
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){return nums[0];}
    
        int left=0,mid,right=nums.length;
        if(nums[right-1]!=nums[right-2]){
            return nums[right-1];
        }
        while(left<right){
            mid = (left+right)/2;

            // kyuki is even position me if next wala same hai to usse pehle wale saare pairs me honge
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }
            // reverse of above explanation
            else{
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }
        }
        return nums[right];
    }
}