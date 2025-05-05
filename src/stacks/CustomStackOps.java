package stacks;

/*
    Problem Statement:
    Design and implement a stack that supports push(), pop(), top(), and
    retrieving the minimum element in constant time (O(1)).

    Methods:
      - void push(int x): Insert element onto the stack.
      - int pop(): Remove and return the top element.
      - int top(): Retrieve (but do not remove) the top element.
      - int getMin(): Retrieve the minimum element in the stack.

    All operations must run in O(1) time.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Stack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    Stack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    void push(int a) {
        mainStack.push(a);
        if (minStack.isEmpty() || minStack.peek() > a) {
            minStack.push(a);
        }
        System.out.println("Successfully inserted: " + a);
    }

    int pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
        int temp = mainStack.pop();
        if (minStack.peek() == temp) {
            minStack.pop();
        }
        System.out.println("Successfully popped: " + temp);
        return temp;
    }

    int top() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return mainStack.peek();
    }

    int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return minStack.peek();
    }

}

public class CustomStackOps {
    public static void main(String[] args) {
        Stack a = new Stack();
        a.push(5);
        a.push(2);
        a.push(10);
        System.out.println("Minimum element in stack: " + a.getMin());
        System.out.println("Popped: " + a.pop());
        System.out.println("Peek: " + a.top());

    }
}
