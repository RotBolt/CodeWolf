package leetcode.may_challenge.week3;

import java.util.ArrayDeque;
import java.util.Deque;

// No other way without pooping till price greater is hit.
// Dont even try to think of achieving const time for next function next time 
public class StockSpanner {

    private final Deque<Integer> stocks;
    private final Deque<Integer> days;
    
    public StockSpanner() {
        this.days = new ArrayDeque<>();
        this.stocks = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stocks.isEmpty() && stocks.peek().intValue() <= price) {
            stocks.pop();
            span += days.pop();
        }
        stocks.push(price);
        days.push(span);
        
        return span;
    }
}