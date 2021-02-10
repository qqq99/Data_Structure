package com.algorithm.stack;
//In order to find the minimum value in the Stack;
//we keep two stack, one is normal, one is the 从大到最小的
public class MinStack {
    Stack stack = new Stack();
    Stack minStack = new Stack();

    public void push(int item){
        stack.push(item);
        if( minStack.empty())
            minStack.push(item);
        else if(item < minStack.peek())
            minStack.push(item);
    }
    public int pop(){
        if(stack.empty())
            throw new IllegalStateException();
        var top = stack.pop();
        if (minStack.peek() == top)
            minStack.pop();
        return top;
    }
    public int min(){
        if(minStack.empty())
            throw new IllegalStateException();
        return minStack.peek();
    }
}
