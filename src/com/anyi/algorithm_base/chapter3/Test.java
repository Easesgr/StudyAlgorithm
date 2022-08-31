package com.anyi.algorithm_base.chapter3;

import java.util.List;

/**
 * 测试树结构
 */
public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeNode cur = treeNode.left;
        cur.left = new TreeNode(4);
        cur.right = new TreeNode(5);
        cur = treeNode.right;
        cur.left = new TreeNode(6);
        cur.right = new TreeNode(7);
        boolean bst = Item8_isBalance.isBalanced(treeNode);
        System.out.println(bst);
    }
}
