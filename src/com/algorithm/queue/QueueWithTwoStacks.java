package com.algorithm.queue;
import java.util.Arrays;
import java.util.Stack;
//implement a queue using two stack, one is used to store, one is to reverse the sequence
//so first stack is used to enqueue; second stack is used to dequeue;
public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //[1,2,3] [4,5]
    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();
        //[3,2,1] [5,4]
        moveStack1ToStack2();
        // 1 2 3 [4,5]
        return stack2.pop();
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        //[3,2,1] [5,4]
        moveStack1ToStack2();
        // 1 2 3 [4,5]
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
    }
    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }
}
