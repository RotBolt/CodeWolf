package dp;

import java.util.ArrayList;

public class CoinChange {

    public static void main(String[] args) {
        int[] denoms = { 2, 3, 5, 6 };
        System.out.println(countCoinChangeCombiMeme(denoms, 10, 0, new int[10 + 1][denoms.length]));
        System.out.println(coinChangeCombiTab(denoms, 10));
        System.out.println(coinChangeCombiMeme(denoms, 10, 0, new ArrayList[11][denoms.length]));
        System.out.println(coinChangePermMeme(denoms, 10, new ArrayList[11]));
        System.out.println(coinChangePermTab(denoms, 10));
    }

    // pehle make the effect of particular currency on all payments
    public static int coinChangeCombiTab(int[] denoms, int amt) {
        int[] store = new int[amt + 1];
        ArrayList<String>[] paths = new ArrayList[amt + 1];
        store[0] = 1;
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<String>();
        }
        paths[0].add("");

        for (int i = 0; i < denoms.length; i++) {
            for (int j = denoms[i]; j <= amt; j++) {
                store[j] += store[j - denoms[i]]; // ways to pay this ammount j using (j-denoms) currency

                for (String way : paths[j - denoms[i]]) {
                    paths[j].add(way + denoms[i]);
                }
            }
        }
        System.out.println(paths[amt]);
        return store[amt];
    }

    // pehle make the effect of all currency on a particular payment
    public static int coinChangePermTab(int[] denoms, int amt) {
        int[] store = new int[amt + 1];
        ArrayList<String>[] paths = new ArrayList[amt + 1];
        store[0] = 1;
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<String>();
        }
        paths[0].add("");
        for (int i = 1; i <= amt; i++) {
            for (int j = 0; j < denoms.length; j++) {
                if (i - denoms[j] >= 0) {
                    store[i] += store[i - denoms[j]]; // paying the particular curreny using all denoms first
                    for (String way : paths[i - denoms[j]]) {
                        paths[i].add(way + denoms[j]);
                    }
                }
            }
        }
        System.out.println(paths[amt]);
        return store[amt];
    }

    public static int countCoinChangeCombiMeme(int[] denoms, int amt, int lpi, int[][] store) {

        if (amt == 0) {
            return 1;
        }

        if (amt < 0) {
            return 0;
        }

        if (store[amt][lpi] != 0) {
            return store[amt][lpi];
        }

        int cLpToAmt = 0;
        for (int i = lpi; i < denoms.length; i++) {
            cLpToAmt += countCoinChangeCombiMeme(denoms, amt - denoms[i], i, store);
        }

        store[amt][lpi] = cLpToAmt;

        return cLpToAmt;

    }

    public static ArrayList<String> coinChangeCombiMeme(int[] denoms, int amt, int lpi, ArrayList<String>[][] store) {

        if (amt == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if (amt < 0) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        if (store[amt][lpi] != null) {
            return store[amt][lpi];
        }

        ArrayList<String> mr = new ArrayList<>();
        for (int i = lpi; i < denoms.length; i++) {
            ArrayList<String> rr = coinChangeCombiMeme(denoms, amt - denoms[i], i, store);
            for (String way : rr) {
                mr.add(way + denoms[i]);
            }
        }

        store[amt][lpi] = mr;
        return mr;
    }

    public static ArrayList<String> coinChangePermMeme(int[] denoms, int amt, ArrayList<String>[] store) {

        if (amt == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if (amt < 0) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        if (store[amt] != null) {
            return store[amt];
        }

        ArrayList<String> mr = new ArrayList<>();
        for (int i = 0; i < denoms.length; i++) {
            ArrayList<String> rr = coinChangePermMeme(denoms, amt - denoms[i], store);
            for (String way : rr) {
                mr.add(way + denoms[i]);
            }
        }

        store[amt] = mr;
        return mr;
    }

}