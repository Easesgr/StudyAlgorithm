package com.anyi.leetcode;

class MyLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){}; // 空构造方法
        public ListNode(int val){
            this.val =val;
        }
    }
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        size = 0;
        head  = new ListNode();
        tail = head;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head.next;
        while(index > 0){
            cur = cur.next;
            index --;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode cur = head.next;
        ListNode newNode = new ListNode(val);
        head.next = newNode;
        newNode.next = cur;
        if(tail == head){
            tail = tail.next;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        while(index > 0){
            cur = cur.next;
            index --;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head;
        while(index > 0){
            cur = cur.next;
            index --;
        }
        cur.next = cur.next.next;
        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */