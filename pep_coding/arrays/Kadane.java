package pep_coding.arrays;

public class Kadane {
    public static void main(String[] args) {
        int[] arr = {2,3,-6,1,2,3,-4,5};
        maxSubArray(arr);
    }

    private static void maxSubArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        int csum = 0;
        int osum = 0;
        for(int i=1;i<arr.length;i++){
            if(csum < 0){
                sb.setLength(0);
                csum=arr[i];
            }else{
                csum+=arr[i];
            }
            sb.append(arr[i]+",");
            if(csum > osum){
                osum = csum;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println("max sub array : {"+sb.toString()+"} = "+osum);

    }


}