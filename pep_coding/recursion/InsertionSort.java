package pep_coding.recursion;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 23, 4, 6, -1, 9 };
        insertionSort(arr, 1, 1);
        for( int ele : arr){
            System.out.print(ele + " ");
        }
    }

    public static void insertionSort(int[] arr, int i, int si) {

        if (si == 0) {
            insertionSort(arr, i + 1, i + 1);
            return;
        }

        if (i == arr.length) {
            return;
        }

        if (arr[si] < arr[si - 1]) {
            int temp = arr[si];
            arr[si] = arr[si - 1];
            arr[si - 1] = temp;

            insertionSort(arr, i, si - 1);
        } else {
            insertionSort(arr, i + 1, i + 1);
        }

    }
}