package com.algorithm.stack;

import java.util.Arrays;

//two stack one array, 一个从上放，一个从下放：
public class TwoStack {
    private int[] items;
    private int top1;
    private int top2;
    public TwoStack(int capacity){
        items = new int[capacity];
        top1 = 0;
        top2 = capacity - 1;
    }
    public void push1(int item){
        if(isFull1())
            throw new StackOverflowError();
        items[top1++] = item;
    }
    public int pop1(){
        if(isEmpty1())
            throw new IllegalStateException();
        return items[--top1];
    }
    private boolean isEmpty1(){
        return top1 == 0;
    }
    private boolean isFull1(){
        return top1 + 1 == top2;
    }
    public void push2(int item){
        if(isFull2())
            throw new StackOverflowError();
        items[top2--] = item;
    }
    public int pop2(){
        if(isEmpty2())
            throw new IllegalStateException();
        return items[++top2];
    }
    private boolean isEmpty2(){
        return top2 == items.length - 1;
    }
    private boolean isFull2(){
        return top2 - 1 == top1;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
