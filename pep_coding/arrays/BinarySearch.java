package pep_coding.arrays;

public class BinarySearch{
    public static void main(String[] args) {
        int[] arr = {12,34,56,78,90,99,134,156,178,190};
        System.out.println(binraySearch(arr, 156) + 1);
    }

    public static int binraySearch(int[] arr, int target){
        int high = arr.length-1;
        int low = 0;

        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}