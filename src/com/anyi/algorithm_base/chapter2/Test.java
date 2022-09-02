package com.anyi.algorithm_base.chapter2;

import java.util.*;

/**
 * 测试链表
 */
public class Test {
    public static void main(String[] args) {
        int[] link = new int[]{2,4,9};
        int[] link2 = new int[]{5,6,4,9};
        ListNode head = arrayToNode(link);
        ListNode head2 = arrayToNode(link2);
        addTwoNumbers(head,head2);
    }

    public static ListNode arrayToNode(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static Node generateRandomNode(int size, int val){
        //产生[0,size]大小的随机整数数组((size+1)*Math.random(1)控制数组大小不会超过size)
       Node head = new Node(1);
       Node cur = head;
       size = (int)(size * Math.random());
        for(int i=0; i < size; i++){
            //给随机数组中元素赋值，范围在(-val,val]之间
            cur.next = new Node(((int)(val*Math.random())));
            cur = cur.next;
        }
        return head.next;
    }


    public static Integer[] nodeToArray(ListNode node){
        List<Integer> old = new ArrayList<Integer>();
        while (node !=null){
            old.add(node.val);
            node = node.next;
        }
        return old.toArray(old.toArray(new Integer[0]));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         思路:
            分别将链表反转
            合并链表的时候进行加法操作
        */
        return mergeSum(l1,l2);
    }

    public static ListNode mergeSum(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head, temp1 = l1,temp2= l2;
        ListNode pre = null;
        while(temp1 !=null && temp2 !=null){
            int sum = temp.val + temp1.val + temp2.val;
            if( sum >= 10){
                temp.val = sum % 10;
                temp.next = new ListNode(1); // 如果大于10就进位
            }else{
                temp.val = sum;
                temp.next = new ListNode(0); // 每次相加准备好下一个节点
            }
            temp1 =temp1.next;
            temp2 =temp2.next;
            pre = temp;
            temp = temp.next;
        }
        if(temp1 == null && temp2 ==null){
            temp = pre;
            temp.next = null;
        }
        while(temp1 !=null){
            int sum = temp.val + temp1.val;
            if(sum >= 10){
                temp.val = sum % 10;
                temp.next = new ListNode(1); // 如果大于10就进位
            }else{
                temp.val = sum;
                temp.next = new ListNode(0); // 如果大于10就进位
            }
            temp1 = temp1.next;
            temp = temp.next;
        }
        while(temp2 !=null){
            int sum = temp.val + temp2.val;
            if(sum >= 10){
                temp.val = sum % 10;
                temp.next = new ListNode(1); // 如果大于10就进位
            }else{
                temp.val = sum;
                temp.next = new ListNode(0); // 如果大于10就进位
            }
            temp2 = temp2.next;
            temp = temp.next;
        }
        return head;
    }
}
