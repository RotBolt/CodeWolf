package arrays;

public class Reverse {
    
    public static void main(String[] args) {
        int[] arr = new int[] {31,2,78,-9,54,32};
        reverse(arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void reverse(int[] arr){
        int left = 0;
        int right=arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}