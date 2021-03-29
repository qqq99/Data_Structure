package com.algorithm.linkedlist;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        //keep a reference to the next node;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);
        //check if the LinkedList is empty or not
        if (isEmpty())
            first = last = node;
        else{
            //keep reference
            last.next = node;
            last = node;
        }
        size++;
    }
    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    private boolean isEmpty(){
        return first == null;
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(current != null){
            if(current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        /*var current = first;
        while(current != null){
            if(current.value == item)
                return true;
            current = current.next;
        }
        return false;*/
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
         else {
            var second = first.next;
            //removed the link between the first and second
            first.next = null;
            first = second;
        }
        size--;
    }
    private Node getPrevious(Node node){
        var current = first;
        while(current != null){
            if(current.next == last )
                return current;
            current = current.next;
        }
        return null;
    }
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    public int size() {
        /*int count;
        var current = first;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    } this is not efficient , what if we have 1 million node*/
        return size;
    }
    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while(current != null){
            array[index++]=current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty()) return;
        //[10 -> 20 -> 30]
        // previous current next
        var previous = first;
        var current = first.next;
        while(current != null){
            var temp = current.next;
            current.next = previous;
            //if you set: next.next = current;then you will lose next.next所以每次只改一个箭头
            previous = current;
            current = temp;
        }
        //set first,last field
        last = first;
        last.next = null;
        //in the last iteration, previous should be first
        first = previous;
    }
    public int getKthFromTheEnd(int k){
        //Find the Kth node from the end in one pass(means you can't traverse to the end and turn around to find the kth node from the end
        //[10 -> 20 -> 30 -> 40 -> 50]
        //             *----dis=2---*
        // k = 1 (50)
        // k = 2 (40) (distance = 1)
        // k = 3 (30) (distance = 2)
        if(isEmpty())
            throw new IllegalStateException();
        var kth = first;
        var b = first;
        for(int i = 0; i < k-1; i++){
            b = b.next;
            if( b==null )
                throw new IllegalArgumentException();
        }
        while( b != last){
            kth = kth.next;
            b = b.next;
        }
        return kth.value;
    }
    public void printMiddle(){
        if(isEmpty())
            throw new IllegalStateException();
        var a = first;
        var b = first;
        while(b != last && b.next != last){
            a = a.next;
            b = b.next;
            b = b.next;
        }
        if( b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ","+ a.next.value);
    }
    public static LinkedList createLoopLinkedList(){
        var list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        var node1 = list.last;
        list.addLast(4);
        list.addLast(5);
        list.last.next = node1;
        return list;
    }
    public boolean hasLoop(){
        var slow = first;
        var fast = first;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
