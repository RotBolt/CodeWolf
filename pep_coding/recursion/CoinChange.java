package pep_coding.recursion;

public class CoinChange {

    public static void main(String[] args) {
        int[] denoms = { 2, 3, 5, 6 };
        // coinChangeCombinations(denoms, 10, 0, "");
        coinChangePermutations(denoms, 10, 0, "");
    }

    static int count = 0;

    public static void coinChangeCombinations(int[] denoms, int amt, int lpi, String asf) {

        if (amt == 0) {
            count++;
            System.out.println(asf + " : count " + count);
            return;
        }

        if (amt < 0) {
            return;
        }

        for (int inst = lpi; inst < denoms.length; inst++) {
            coinChangeCombinations(denoms, amt - denoms[inst], inst, asf + denoms[inst] + ", ");
        }
    }

    public static void coinChangePermutations(int[] denoms, int amt, int lpi, String asf) {

        if (amt == 0) {
            count++;
            System.out.println(asf + " : count " + count);
            return;
        }

        if (amt < 0) {
            return;
        }

        for (int inst = 0; inst < denoms.length; inst++) {
            coinChangePermutations(denoms, amt - denoms[inst], inst, asf + denoms[inst] + ", ");
        }
    }

}