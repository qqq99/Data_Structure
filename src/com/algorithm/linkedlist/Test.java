package com.algorithm.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
//test java 自带的 LinkedList
public class Test {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        //void	addLast(E e) Appends the specified element to the end of this list.
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addFirst(0);
        list.addFirst(1);

        list.removeLast();
        list.removeFirst();
        list.remove(3);
        System.out.println(list.contains(3));
        System.out.println(list.indexOf(4));
        System.out.println(list.size());
        System.out.println(list.toArray());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list);
    }
}
