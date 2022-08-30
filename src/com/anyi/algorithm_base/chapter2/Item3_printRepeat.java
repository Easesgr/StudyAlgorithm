package com.anyi.algorithm_base.chapter2;

/**
 * 给定两个链表，打印链表重复的部分
 */
public class Item3_printRepeat {
    public static Node printRepeat(Node N1,Node N2){
        if (N1 ==null || N2 ==null){
            return null;
        }
        Node repeat = new Node(1);
        while (N1 !=null && N2 != null){
            if (N1.value < N2.value){
                N1 = N1.next;
            }else if(N1.value > N2.value){
                N2 = N2.next;
            }else {
                repeat.next = N1;
                repeat = N1;
                N1 = N1.next;
                N2 = N2.next;
            }
        }
        return repeat.next;
    }
}
