package com.anyi.algorithm_base.chapter2;

import java.util.Stack;

/**
 * 判断一个链表是否是回环链表
 */
public class Item4_nodeLoopback {

    public static boolean isLoopback(Node head){
        if (head ==null || head.next ==null){
            return true;
        }
        return isLoopbackCode(head);
    }
    // 采用栈来判断
    public static boolean isLoopbackStack(Node head){
        // 申请一个栈，让所有元素入栈
        Stack<Node> nodes = new Stack<>();
        Node cur = head;
        while (cur !=null){
            nodes.push(cur);
            cur = cur.next;
        }
        boolean isLoopback = true;
        cur = head;
        while (cur != null){
            if (cur.value != nodes.pop().value){
                isLoopback =false;
            }
            cur = cur.next;
        }
        return isLoopback;
    }

    // 采用几个变量实现
    public static boolean isLoopbackCode(Node head){
        // 准备一个快指针和一个慢指针
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 此时 n1 到达中点，n2到达终点 中点开始反转列表
        n2 = n1.next;
        n1.next =null;
        Node n3 = null;
        while (n2 !=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // n1 到达 开始从头和从尾巴开始对比
        n3 = n1; // 记录末尾位置
        n2 = head;
        boolean isLoopback = true;
        while (n1 !=null && n2 !=null){
            if (n1.value != n2.value){
                isLoopback =false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 恢复原来数组
        n1 = n3.next;
        n3.next =null;
        while (n1 !=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return isLoopback;
    }

}
