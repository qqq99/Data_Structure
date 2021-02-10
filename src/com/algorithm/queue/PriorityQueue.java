package com.algorithm.queue;
import java.util.Arrays;
import java.util.Queue;

//items are processed based on the priority, not the order in which they joined the queue
public class PriorityQueue {
//implement priority queue using array
    private int[] items = new int[5];
    private int count;
//[1,3,5,7,9] 6
    //O(n)
    public void add(int item){
        if(isFull())
            throw new IllegalStateException();
        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }
    private int shiftItemsToInsert(int item){
        //from the end shifting items to the back if they are bigger
        int i;
        for(i = count-1; i >= 0; i--){
            if( items[i] > item )
                items[i+1] = items[i];
            else
                break;
        }
        return i+1;
    }
    //O(1)
    //process the biggest item first
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        var item = items[--count];
        items[count] = 0;
        return item;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == items.length;
    }
    public String toString(){
        return Arrays.toString(items);
    }

}
