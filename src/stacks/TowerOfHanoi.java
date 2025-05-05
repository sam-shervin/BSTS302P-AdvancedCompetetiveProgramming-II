package stacks;

/*
    Problem Statement:
    Iterative Tower of Hanoi
    ------------------------
    Move n disks from Source (S) to Destination (D) using Auxiliary (A)
    rods. You may only move one disk at a time, and a larger disk may never
    be placed on top of a smaller one.

    Algorithm (iterative):
      1. totalMoves = 2^n - 1
      2. If n is even, swap roles of D and A.
      3. For move = 1 to totalMoves:
           if move % 3 == 1: move between S and D
           if move % 3 == 2: move between S and A
           if move % 3 == 0: move between A and D
*/

import java.util.*;

public class TowerOfHanoi {
    Deque<Integer> s = new ArrayDeque<>();
    Deque<Integer> a = new ArrayDeque<>();
    Deque<Integer> d = new ArrayDeque<>();

    int n = 5; // get from input
    String printStmt = "Move disk %d from %c to %c%n";
    void makeAMove(Deque<Integer> src, Deque<Integer> dest, char s, char d) {
        if (dest.isEmpty() || (!src.isEmpty())&&(dest.peek() > src.peek())) {
            int temp = src.pop();
            dest.push(temp);
            System.out.printf(printStmt, temp, s, d);
        }
        else {
            int temp = dest.pop();
            src.push(temp);
            System.out.printf(printStmt, temp, d, s);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi solution = new TowerOfHanoi();
        int nos = (1 << solution.n) - 1;
        char s;
        char a;
        char d;
        if (solution.n % 2 == 0) {
            
            a = 'D';
            d = 'A';
        } else {
            a = 'A';
            d = 'D';
        }
        for (int i = solution.n; i >= 1; i--) {
            solution.s.push(i);
        }
        s = 'S';
        for (int i = 1; i <= nos; i++) {
            if (i % 3 == 0)
                solution.makeAMove(solution.a, solution.d, a, d);
            else if (i % 3 == 1)
                solution.makeAMove(solution.s, solution.d, s, d);
            else if (i % 3 == 2)
                solution.makeAMove(solution.s, solution.a, s, a);
        }

    }
}
