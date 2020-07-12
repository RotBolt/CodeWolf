package dp;

public class LBS {
    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
        LBST(arr);
    }

    public static void LBST(int[] arr) {
        int[] lis = new int[arr.length];
        String[] plis = new String[arr.length];

        lis[0] = 1;
        plis[0] = arr[0] + " ";

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    plis[i] = plis[j] + arr[i] + " ";
                }
            }
        }

        int[] lds = new int[arr.length];
        String[] plds = new String[arr.length];

        lds[arr.length - 1] = 1;
        plds[arr.length - 1] = arr[arr.length - 1] + " ";

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                    plds[i] = arr[i] + " " + plds[j];
                }
            }
        }

        int omax = 0;
        String opath = "";

        for (int i = 0; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
                opath = plis[i] + plds[i].substring(3);
            }
        }

        System.out.println(omax);
        System.out.println(opath);
    }

}