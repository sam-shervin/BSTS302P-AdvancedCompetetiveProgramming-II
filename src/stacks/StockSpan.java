package stacks;

/*
    Problem Statement:
    ------------------
    The Stock Span Problem:
      Given an array `prices[]` of daily stock prices of size N,
      the "span" S[i] of the stock's price on day i is the maximum number
      of consecutive days up to and including day i, for which the price
      on those days was ≤ prices[i].

    Example:
      prices = [97, 64, 32, 11, 22, 56]
      spans  = [ 1,  1,  1,  1,  2,  4 ]

    Efficient O(N) solution using a stack of indices.
*/

import java.util.*;

public class StockSpan {
    Deque<Integer> spanStack = new ArrayDeque<>();

    public int[] calculate(int[] a, int len) {
        int[] span = new int[len];
        for (int i = 0; i < len; i++) {
            while (!spanStack.isEmpty() && a[spanStack.peek()] <= a[i])
                spanStack.pop();
            span[i] = (spanStack.isEmpty()) ? (i + 1) : (i - spanStack.peek());
            spanStack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        StockSpan solution = new StockSpan();

        int[] stock = { 97, 64, 32, 11, 22, 56};
        int len = stock.length;
        int[] span = solution.calculate(stock, len);
        System.out.print("Stock span is: {");
        for (int i = 0; i < len; i++) {
            System.out.print(span[i]);
            if (i != len - 1)
                System.out.print(",");
        }
        System.out.println("}");

    }

}
