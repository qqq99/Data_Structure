package com.algorithm.linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list.size());
        System.out.println(list.indexOf(40));
        System.out.println(list.indexOf(20));
        System.out.println(list.contains(10));
        System.out.println(list.contains(50));
        list.removeFirst();
        list.removeLast();
        list.reverse();
        System.out.println(list.size());
        System.out.println(list.getKthFromTheEnd(1));
        LinkedList.createLoopLinkedList();
    }
}
