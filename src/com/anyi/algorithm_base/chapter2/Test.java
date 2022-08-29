package com.anyi.algorithm_base.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试链表
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Node node = generateRandomNode(20, 100);
            Integer[] integers = nodeToArray(node);
            System.out.printf(Arrays.toString(integers));

            node = Item1_SingleReserve.reserve(node);
            System.out.printf("=======反转后========");
            integers = nodeToArray(node);
            System.out.printf(Arrays.toString(integers));
            System.out.println();
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
