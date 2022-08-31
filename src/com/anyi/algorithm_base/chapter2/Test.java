package com.anyi.algorithm_base.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试链表
 */
public class Test {
    public static void main(String[] args) {
        int[] link = new int[]{4,19,14,5,-3,1,8,5,11,15};
        ListNode head = arrayToNode(link);
        ListNode node = Item7_nodeSort.sortListBack(head);
        Integer[] integers = nodeToArray(node);
        System.out.println(Arrays.toString(integers));
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


}
