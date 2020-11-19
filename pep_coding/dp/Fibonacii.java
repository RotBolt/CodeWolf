package pep_coding.dp;

public class Fibonacii {

    public static void main(String[] args) {
        int num = 45;
        int[] store = new int[num + 1];
        System.out.println(fibonacciMeme(num, store));
        System.out.println(fibonacci(num));
        System.out.println(fibonacciIter(num));
        System.out.println(fibonacciTab(num));
    }

    public static int fibonacciTab(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int x = 2; x <= n; x++) {
            f[x] = f[x - 1] + f[x - 2];
        }
        return f[n];
    }

    public static int fibonacciIter(int n) {
        int n0 = 0;
        int n1 = 1;
        int nA = -1;
        for (int i = 2; i <= n; i++) {
            nA = n0 + n1;
            n0 = n1;
            n1 = nA;
        }

        return nA;

    }

    public static int fibonacci(int num) {

        if (num == 0 || num == 1) {
            return num;
        }

        int n1 = fibonacci(num - 1);
        int n2 = fibonacci(num - 2);

        return n1 + n2;

    }

    public static int fibonacciMeme(int num, int[] store) {

        if (num == 0 || num == 1) {
            return num;
        }

        if (store[num] != 0) {
            return store[num];
        }

        int n1 = fibonacciMeme(num - 1, store);
        int n2 = fibonacciMeme(num - 2, store);

        store[num] = n1 + n2;
        return n1 + n2;

    }

}