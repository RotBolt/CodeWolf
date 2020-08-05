package leetcode.may_challenge.week2;

import java.util.*;

public class RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(stack.size() != 0 && stack.getLast() > c && count++ < k) {
                stack.removeLast();
            }
            
            stack.addLast(c);
        }
        
        while(count++ < k) stack.removeLast();
        while(stack.size() != 0 && stack.getFirst() == '0') stack.removeFirst();
        StringBuilder sb = new StringBuilder();
        for(char c: stack) sb.append(c);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

}