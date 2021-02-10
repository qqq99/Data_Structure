package com.algorithm.stack;
import java.util.Stack;
public class Test {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        var top = stack.pop();
        System.out.println(stack);
        System.out.println(top);
        top = stack.peek();
        System.out.println(top);
        System.out.println(stack);
    }
}
