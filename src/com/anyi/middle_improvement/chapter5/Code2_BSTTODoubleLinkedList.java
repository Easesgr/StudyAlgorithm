package com.anyi.middle_improvement.chapter5;

import com.anyi.algorithm_base.chapter3.TreeNode;

/**
 * 将一颗搜索二叉树，转换成双向链表返回
 */
public class Code2_BSTTODoubleLinkedList {
    public static class Node{
        public int val;
        public Node next;
        public Node pre;
        public Node(int val){
            this.val = val;
        }
    }
    /**
     * 树形dp问题
     */
    public static class info{
        public Node start;
        public Node end;
        public info(Node s,Node e){
            this.start = s;
            this.end = e;
        }
    }
    public static info BSTTODoubleLinkList(TreeNode root){
        if(root == null){ // base case
            return new info(null,null);
        }
        // 从左右树要信息
        info leftInfo = BSTTODoubleLinkList(root.left);
        info rightInfo = BSTTODoubleLinkList(root.right);
        // 拆黑盒
        Node cur = new Node(root.value); // 创建当前节点
        // 左右节点能不能串起来
        if(leftInfo.end !=null){
            leftInfo.end.next = cur;
            cur.pre = leftInfo.end;
        }
        if(rightInfo.start !=null){
            cur.next = rightInfo.start;
            rightInfo.start.pre = cur;
        }
        // 返回节点
        return new info(leftInfo.start != null?leftInfo.start:cur,rightInfo.end !=null?rightInfo.end:cur);
    }
}
