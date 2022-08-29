package com.anyi.algorithm_base.chapter2;

/**
 * 双向链表反转
 * 让每个节点的前面指向自己的后面，让后面指向自己的前面
 */
public class Item2_doubleNodeReserve {
    public static class DoubleNode {
        public int data;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.data = data;
        }
    }
    public static DoubleNode reserve(DoubleNode head){
        DoubleNode n1 = null;
        DoubleNode n2 = null;
        while ( head !=null){
            // n1 表示后一节点
            n1 = head.next;
            // 让头节点的下个指向null，前一个节点
            head.next = n2;
            // 让头节点的尾巴指向后一节点
            head.pre = n1;
            // 让n2指针往后移动一位
            n2 = head;
            // 同时头也往后一位
            head = n1;
        }
        return n2;
    }
}
