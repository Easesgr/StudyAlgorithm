package com.anyi.middle_improvement.chapter5;

import com.anyi.algorithm_base.chapter3.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.awt.*;

/**
 * 一棵树中，最大的搜索二叉树，返回最大搜索二叉树的头节点，如果有相同大小的，返回一个即可
 */
public class Code3_BiggestSubBSTInTree {
    public static class info{// 递归返回实体类
        public int min;
        public int max;
        public boolean isBST;
        public TreeNode BSTHeadNode; // 最大搜索二叉树的头节点
        public int BSTSize;
        public info(int mn, int mx, boolean is, TreeNode headNode,int size){
            this.min = mn;
            this.max = mx;
            this.isBST = is;
            this.BSTHeadNode = headNode;
            this.BSTSize = size;
        }
    }
    public static info biggestSubBSTTree(TreeNode root){
        if(root == null){ // 如果到了最后，直接返回null
            return null;
        }
        // 向左右要信息
        info leftInfo = biggestSubBSTTree(root.left);
        info rightInfo = biggestSubBSTTree(root.right);
        // 拆黑盒
        // 三种情况
        int min = root.value;
        int max = root.value;
        // 更新
        if(leftInfo !=null){
            // 最小值就是我与当前节点的最小值
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
        }
        if(rightInfo != null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
        }
        int BSTSize = 0;
        int value = root.value;
        TreeNode BSTHeadNode = null; // 最大搜索二叉树的头节点
        // root 不参与其中，那么最大的节点和最大的size就是左右返回中大的一个
        if(leftInfo !=null){
            BSTSize = leftInfo.BSTSize;
            BSTHeadNode = leftInfo.BSTHeadNode;
        }
        if(rightInfo !=null && BSTSize < rightInfo.BSTSize){
            BSTSize = rightInfo.BSTSize;
            BSTHeadNode = rightInfo.BSTHeadNode;
        }
        // root 参与其中，那就需要判断当前节点是否符合条件来更新需要返回的值
        boolean isBST = false;
        if((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST)){
            if((leftInfo == null || leftInfo.max < value) && (rightInfo == null || rightInfo.min > value)){
                isBST = true;
                BSTHeadNode = root;
                BSTSize = leftInfo.BSTSize + 1 + rightInfo.BSTSize;
            }
        }
        return new info(min,max,isBST, BSTHeadNode,BSTSize);
    }
}
