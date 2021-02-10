package com.algorithm.queue;
//Everytime involve reverse the oder of sth, use Stack
import java.util.Stack;
import java.util.Queue;
public class QueueReverser {

    public static void reverse(Queue<Integer> queue, int k){
        if(k<0 || k>queue.size())
            throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();
        //1 push to stack
        for(int i = 0; i< k; i++){
            stack.push(queue.remove());
        }
        //2 pop then add to queue, order reversed
        while(!stack.empty()){
            queue.add(stack.pop());
        }
        //3 for the rest queue.size()-k items, remove then add (same order)
        for(int i= 0; i < queue.size() - k ;i++ ){
            queue.add(queue.remove());
        }
    }
}
