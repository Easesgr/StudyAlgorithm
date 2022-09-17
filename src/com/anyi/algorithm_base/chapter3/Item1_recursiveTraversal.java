package com.anyi.algorithm_base.chapter3;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedHashMap;

/**
 * 二叉树递归的 前序，中序，后序 遍历
 */
public class Item1_recursiveTraversal extends LinkedHashMap<Integer, Integer> {

    /**
     * 前序
     * @param head
     */
    public static void preTraversal(TreeNode head) {
        if (head == null){
            return;
        }
        System.out.println(head.value + "");
        preTraversal(head.left);
        preTraversal(head.right);
    }
    /**
     * 中序
     * @param head
     */
    public static void inTraversal(TreeNode head){
        if (head == null){
            return;
        }
        inTraversal(head.left);
        System.out.println(head.value + "");
        inTraversal(head.right);
    }
    /**
     * 后续
     * @param head
     */
    public static void backTraversal(TreeNode head){
        if (head == null){
            return;
        }
        backTraversal(head.left);
        backTraversal(head.right);
        System.out.println(head.value + "");
    }
}
