package stacks;

/*
    Problem Statement:
    ------------------
    Given two integer arrays `input[]` and `output[]` of the same length n,
    determine if `output[]` is a valid stack permutation of `input[]`. A stack
    permutation means you can obtain `output[]` by pushing the elements of
    `input[]` onto a stack (in order) and popping at arbitrary times.

    Example:
      input  = [1, 2, 3]
      output = [2, 1, 3]
      Answer = YES
      (Operations: push(1), push(2), pop→2, pop→1, push(3), pop→3)

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

import java.util.*;

public class StackPermutation {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        int[] output = { 3, 1, 3 };
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int x : input) {
            stack.push(x);
            while (!stack.isEmpty() && output[j] == stack.peek()) {
                stack.pop();
                j++;
                if (j == output.length)
                    break;
            }
        }
        if (j == output.length) {
            System.out.println("It is a stack permutation");
        } else {
            System.out.println("It is not a stack permutation");
        }

    }
}
