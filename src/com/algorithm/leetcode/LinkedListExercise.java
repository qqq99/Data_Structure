package com.algorithm.leetcode;

import com.algorithm.linkedlist.LinkedList;

public class LinkedListExercise {
    public static void main(String[] args){

    }
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {};
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            //转变箭头，也不要丢失cur.next
            pre = cur;
            cur = temp;
            //pre和cur同时向前一步
        }
        return pre;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
