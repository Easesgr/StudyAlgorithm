package com.anyi.algorithm_base.chapter2;

import java.lang.annotation.Native;

/**
 * 单链表反转
 */
public class Item1_SingleReserve {
    // Node节点

    // 逆序输出单链表，返回头结点
    public static Node reserve(Node head){
        Node n1 = head;
        Node n2 = head.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }

}
