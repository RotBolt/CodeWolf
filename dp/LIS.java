package dp;

public class LIS {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
        LIST(arr);
        LISM(arr);
    }

    public static void LIST(int[] arr) {
        int[] store = new int[arr.length];
        String[] path = new String[arr.length];

        store[0] = 1;
        path[0] = arr[0] + " ";
        int maxi = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && store[i] < store[j] + 1) {
                    store[i] = store[j] + 1;
                    path[i] = path[j] + arr[i] + " ";
                }
            }
            if (store[i] > store[maxi]) {
                maxi = i;
            }
        }

        System.out.println(store[maxi]);
        System.out.println(path[maxi]);
    }

    public static void LISM(int[] arr) {
        int max = 0;
        int[] store = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int m = LISM(arr, i, store);
            if (m > max) {
                max = m;
            }
        }
        System.out.println("Max LIS " + max);
    }

    public static int LISM(int[] arr, int point, int[] store) {

        if (point == 0) {
            return 1;
        }

        if (store[point] != 0) {
            return store[point];
        }

        int lenEndAtPoint = 0;
        for (int i = 0; i < point; i++) {
            if (arr[i] < arr[point]) {
                int lenEndingAtI = LISM(arr, i, store);
                if (lenEndAtPoint < lenEndingAtI) {
                    lenEndAtPoint = lenEndingAtI;
                }
            }
        }

        store[point] = lenEndAtPoint + 1;
        return lenEndAtPoint + 1;
    }

}