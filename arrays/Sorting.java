package arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = new int[] {31,2,78,-9,54,32};
        // bubbleSort(arr);
        // selectSort(arr);
        insertionSort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min_idx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;

        }
    }

    private static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i;
            while(j>0){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
                j--;
            }
        }
    }

}