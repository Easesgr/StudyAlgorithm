package com.anyi.algorithm_base.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试链表
 */
public class Test {
    public static void main(String[] args) {
   /*     Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        node.next = node1;
        node1.next =node2;
        node2.next = node3;
        node3.next = node4;*/
        for (int i = 0; i < 1000; i++) {
            Node node = generateRandomNode(30, 50);
            Node partition = Item5_nodePartition.partition(node, 20);
            Integer[] integers = nodeToArray(partition);
            System.out.println(Arrays.toString(integers));
        }
    }

    public static Node generateRandomNode(int size, int value){
        //产生[0,size]大小的随机整数数组((size+1)*Math.random(1)控制数组大小不会超过size)
       Node head = new Node(1);
       Node cur = head;
       size = (int)(size * Math.random());
        for(int i=0; i < size; i++){
            //给随机数组中元素赋值，范围在(-value,value]之间
            cur.next = new Node(((int)(value*Math.random())));
            cur = cur.next;
        }
        return head.next;
    }


    public static Integer[] nodeToArray(Node node){
        List<Integer> old = new ArrayList<Integer>();
        while (node !=null){
            old.add(node.value);
            node = node.next;
        }
        return old.toArray(old.toArray(new Integer[0]));
    }


}
