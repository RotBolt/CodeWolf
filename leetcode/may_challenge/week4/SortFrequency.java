package leetcode.may_challenge.week4;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int i = 0; i < freqMap.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}