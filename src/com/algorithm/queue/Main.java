package com.algorithm.queue;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        var front = queue.dequeue();
        queue.dequeue();
        System.out.println(front);
        System.out.println(queue);
        queue.enqueue(6);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(7);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

        QueueWithTwoStacks queue2 = new QueueWithTwoStacks();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        queue2.enqueue(4);
        queue2.enqueue(5);
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());

        PriorityQueue queue3 = new PriorityQueue();
        queue3.add(7);
        queue3.add(5);
        queue3.add(9);
        System.out.println(queue3);
        //queue3.remove();
        System.out.println(queue3.remove());
        System.out.println(queue3);
        queue3.add(1);
        queue3.add(9);
        queue3.add(3);
        System.out.println(queue3);
        while(!queue3.isEmpty())
            System.out.println(queue3.remove());

        Queue<Integer> queue4 = new ArrayDeque<Integer>();
        queue4.add(1);
        queue4.add(2);
        queue4.add(3);
        queue4.add(4);
        queue4.add(5);
        QueueReverser.reverse(queue4,3);
        System.out.println(queue4);
    }
}
