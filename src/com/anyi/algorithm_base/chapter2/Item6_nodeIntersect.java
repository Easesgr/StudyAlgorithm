package com.anyi.algorithm_base.chapter2;

/**
 * 给定两个链表 head1 和 head2 ,两个链表可能有环可能没有，
 * 请找出两个链表相交的第一个节点并返回
 */
public class Item6_nodeIntersect {

    // 主函数
    public static Node intersect(Node head1,Node head2){
        Node res = null;
        if (head1 ==null || head2 == null){
            return null;
        }
        // 判断两个表是否有环，并且返回入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 ==null){
            res = getNoLoop(head1,head2);
        }else if (loop1 != null && loop2 !=null){
            res = getLoop(head1,loop1,head2,loop2);
        }
        return res;
    }

    // 当没有环的时候找出相交点
    public static Node getNoLoop(Node head1, Node head2){
        // 两个节点先遍历，拿到左后一个节点并且记录节点的长度
        int len = 0;
        Node node = null;
        Node cur = head1;
        while (cur.next != null){
            len ++;
            cur = cur.next;
        }
        node = cur;
        cur = head2;
        while (cur.next != null){
            len --;
            cur = cur.next;
        }
        // 首先就需要满足两个终点相等
        if (cur == node){
            cur = len > 0 ? head1 : head2; // 如果大于 0 就是head1 长，否则就是 head2 长
            head2 = head2 == cur ? head1: head2;
            len = Math.abs(len); // 去绝对值
            while (len > 0 ){
                cur = cur.next;
                len --;
            }
            while (cur != head2){
                cur = cur.next;
                head2 = head2.next;
            }
            return cur;
        }
        return null;
    }
    // 当有环的时候找出相交点
    public static Node getLoop(Node head1,Node loop1,Node head2,Node loop2){
        if (loop1 == loop2 ){ // 入环点相同
            int len = 0;
            Node cur = head1;
            while (cur != loop1){
                len ++;
                cur = cur.next;
            }
            cur =head2;
            while (cur != loop2){
                len--;
                cur = cur.next;
            }
            cur = len > 0 ? head1: head2;
            head2 = cur == head1 ? head2 : head1;
            len = Math.abs(len);
            while (len > 0){
                cur = cur.next;
            }
            while (cur != head2){
                cur = cur.next;
                head2 = head2.next;
            }
            return cur;
        }else { // 入环点不同
            while (head1 != loop2){
                head1 = head1.next;
            }
            return head1;
        }
    }


    public static Node getLoopNode(Node head){
        // 如果三个节点都没有不可能成环
        if (head.next == null || head.next.next ==null){
            return null;
        }
        // 准备一个满指针和快指针
        Node slow = head.next;
        Node quick = head.next.next;
        while (slow !=null && quick !=null){
            if (slow == quick){ // 两节点相等，直接退出
                break;
            }
            slow =slow.next;
            quick = quick.next.next;
        }
        // 再让快节点返回到其实位置,两个人同时走，相等的时候就是环
        quick = head;
        while (quick != null && slow !=null){
            if (quick == slow){
                return quick;
            }
            quick = quick.next;
            slow = slow.next;
        }
        return null;
    }
}
