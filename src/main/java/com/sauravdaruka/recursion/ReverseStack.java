package com.sauravdaruka.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //reverseApproach1(stack);   // Time Complexity : O(n ^ 2)   Space Complexity : O(n) -> Auxiliary space (temp stack)
        reverseApproach2(stack);     // Time Complexity : O(n ^ 2)   Space Complexity : O(1) -> Auxiliary space
        System.out.println(stack);
    }

    static void reverseApproach1(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int top = stack.pop();
        reverseApproach1(stack);

        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty())
            temp.push(stack.pop());

        stack.push(top);

        while (!temp.isEmpty())
            stack.push(temp.pop());
    }
    static void reverseApproach2(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int top = stack.pop();
        reverseApproach2(stack);
        insertAtBottom(stack, top);
    }
    static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }
}
