package com.anyi.algorithm_base.chapter2;


import com.sun.org.apache.xpath.internal.operations.Lt;

/**
 * 给你一个链表，将链表的左侧分成大于k的区域，
 * 将链表左侧防止小于 k，中间等于k 右侧大于 k
 */
public class Item5_nodePartition {

    // 主方法
    public static Node partition(Node head ,int k){
        // 准备六个节点
        Node lH = null; // 左侧头
        Node lT = null; // 左侧尾
        Node mH = null; // 中间头
        Node mT = null; // 中间尾
        Node rH = null; // 右侧头
        Node rT = null; // 右侧尾
        Node next = null; // 辅助 截断已经排序的节点
        while (head !=null){
            next = head.next;
            head.next = null;
            if (head.val < k){  // 如果小于k
                if (lH == null){
                    lH = head;
                    lT = head;
                }else {
                    lT.next = head;
                    lT = head;
                }
            }else if (head.val > k){ // 大于k
                if (rH == null){
                    rH = head;
                    rT = head;
                }else {
                    rT.next = head;
                    rT = head;
                }
            }else { // 等于k
                if (mH == null){
                    mH = head;
                    mT = head;
                }else {
                    mT.next = head;
                    mT = head;
                }
            }
            head =next;
        }
        // 将三个链表链接起来
        if (lT != null){ // 判断小于部分是否有值
            lT.next = mH;
            mT = mT == null ? lT : mT; // 不管是左边尾节点有值还是右边尾节点有值，返回的都是 中间的尾节点
        }
        if (mT != null){ // 如果前连个节点中有一个不是null就让前面的节点连接最后的头
            mT.next = rH;
        }
        // 如果前两个有值就返回前面的节点，最后没有就返回最后的节点也就只有大于部分
        return lH !=null ? lH :(mH != null ? mH : rH);
    }
}
