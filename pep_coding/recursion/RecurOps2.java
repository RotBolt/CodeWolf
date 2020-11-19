package pep_coding.recursion;

public class RecurOps2 {

    public static void main(String[] args) {
        // int[] arr = { 10, 20, 30, 40, 60, 70 };
        // printTargetSumSubSets(arr, 70, 0, 0, "");

        // printPermutations("abc", "");
        // printPermutationsSB(new StringBuilder("abc"), new StringBuilder());
        // printPermutations2("abc", "");
        printPermutations2SB(new StringBuilder("abc"), new StringBuilder());
    }

    public static void printTargetSumSubSets(int[] arr, int tar, int vidx, int setSum, String set) {

        if (vidx == arr.length) {
            if (setSum == tar) {
                System.out.println(set);
            }
            return;
        }

        printTargetSumSubSets(arr, tar, vidx + 1, setSum, set);
        printTargetSumSubSets(arr, tar, vidx + 1, setSum + arr[vidx], set + " " + arr[vidx]);
    }

    public static void printPermutations(String str, String asf) {

        if (str.isEmpty()) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            printPermutations(left + right, asf + str.charAt(i));
        }

    }

    public static void printPermutationsSB(StringBuilder str, StringBuilder asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            str.deleteCharAt(i);
            asf.append(ch);
            printPermutationsSB(str, asf);
            asf.deleteCharAt(asf.length() - 1);
            str.insert(i, ch);
        }

    }

    public static void printPermutations2(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        for (int i = 0; i <= asf.length(); i++) {
            String left = asf.substring(0, i);
            String right = asf.substring(i);
            printPermutations2(ros, left + ch + right);
        }

    }

    public static void printPermutations2SB(StringBuilder str, StringBuilder asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);
        str.deleteCharAt(0);
        for (int i = 0; i <= asf.length(); i++) {
            asf.insert(i, ch);
            printPermutations2SB(str, asf);
            asf.deleteCharAt(i);
        }
        str.insert(0, ch);
    }
}