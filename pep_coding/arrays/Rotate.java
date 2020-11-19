package pep_coding.arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] arr = new int[]{12,34,-9,0,7,4};
        int d =3;
        rotate(arr, d);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void rotate(int[] arr, int k){
        reverse(arr, 0, arr.length-1-k);
        reverse(arr, arr.length-k, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    private static void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
}