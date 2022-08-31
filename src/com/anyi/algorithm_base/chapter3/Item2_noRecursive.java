package com.anyi.algorithm_base.chapter3;

import java.util.Stack;

/**
 * 非递归 二叉树的前序 、 中序、 后续
 */
public class Item2_noRecursive {

    // 非递归前序遍历
    public static void preRecursive(TreeNode head){
        if (head.left == null && head.right == null){
            System.out.println(head.value + "");
        }
        Stack<TreeNode> stack = new Stack<>();  // 采用一个栈
        stack.push(head); // 头节点压栈
        while (!stack.isEmpty()){ // 如果栈没空就持续做
            TreeNode pop = stack.pop(); // 弹出
            System.out.println(pop.value + "");
            if (pop.right !=null){ // 想让右边的压栈
                stack.push(pop.right);
            }
            if (pop.left !=null){ // 再让左边的压栈
                stack.push(pop.left);
            }
        }
    }
    // 非递归后序遍历
    public static void backRecursive(TreeNode head){
        if (head.left == null && head.right == null){
            System.out.println(head.value + "");
        }
        // 准备两个栈
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> finalStack = new Stack<>();
        stack.push(head); // 头节点压栈
        while (!stack.isEmpty()){ // 如果栈没空就持续做
            TreeNode pop = stack.pop(); // 弹出时将节点压到另一个栈里面
            finalStack.push(pop);
            if (pop.right !=null){ // 想让右边的压栈
                stack.push(pop.right);
            }
            if (pop.left !=null){ // 再让左边的压栈
                stack.push(pop.left);
            }
        }
        while (!finalStack.isEmpty()){
            System.out.println(finalStack.pop().value + "");
        }
    }
    // 非递归中序遍历
    public static void inRecursive(TreeNode head){
        // 同样采用栈
        Stack<TreeNode> stack = new Stack<>();
        // 先让左树压栈
        while (!stack.isEmpty() || head != null){ // 只要栈不是空 或者 head 还没有到 null
            if (head != null){ // 如果 head 到了null 说明遍历到了左树最下方
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop(); // 当了左树最下方就开始退栈
                System.out.println(head.value + "");
                head = head.right; // 赋值成前出栈的右树，如果是null 接着出栈
            }
        }
    }
}
