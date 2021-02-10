package com.algorithm.queue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        var front = queue.remove();
        System.out.println(queue);
        System.out.println(front);
        reverse(queue);
        System.out.println(queue);
    }
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.empty()){
            queue.add(stack.pop());
        }
    }
}
