package pep_coding.dp;

import java.util.PriorityQueue;

public class SuperUglyNumber {

    public static void main(String[] args) {
        System.out.println(getNthSuperUgly(1000, new int[] { 2, 3, 5 }));
    }

    // O(n*k)
    public static long getNthSuperUglyNumber(int num, int[] primes) {
        long[] sugly = new long[num];
        int[] pi = new int[primes.length];
        long[] multiples = new long[primes.length];
        for (int i = 0; i < primes.length; i++) {
            multiples[i] = primes[i];
        }
        sugly[0] = 1;
        long nextSugly = 1;
        for (int i = 1; i < num; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < multiples.length; j++) {
                if (min > multiples[j]) {
                    min = multiples[j];
                }
            }
            nextSugly = min;
            sugly[i] = nextSugly;

            for (int j = 0; j < pi.length; j++) {
                if (nextSugly == multiples[j]) {
                    pi[j] += 1;
                    multiples[j] = sugly[pi[j]] * primes[j];
                }
            }
        }
        return nextSugly;
    }

    public static long getNthSuperUgly(int num, int[] primes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        int count = 0;
        int sugly = 1;
        for (int i = 0; i < primes.length; i++) {
            minHeap.add(primes[i]);
        }
        while (count < num + 1) {
            sugly = minHeap.peek();
            minHeap.poll();
            // to avoid counting duplicate factors which we pushed stupidly
            if (sugly != minHeap.peek()) {
                for (int i = 0; i < primes.length; i++) {
                    minHeap.add(sugly * primes[i]);
                }
                count++;
            }
        }
        return sugly;
    }

}