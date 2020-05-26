package arrays;

public class Inverse {

    public static void main(String[] args) {
        int[] arr = new int[] {3,0,1,4,2};
        int[] inv = inverse(arr);
        for(int num:inv){
            System.out.print(num+" ");
        }
    }
    private static int[] inverse(int[] arr){
        int[] inv = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            inv[arr[i]] = i;
        }

        return inv;
    }
    
}