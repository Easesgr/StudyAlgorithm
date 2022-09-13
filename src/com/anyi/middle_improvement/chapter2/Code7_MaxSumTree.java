package com.anyi.middle_improvement.chapter2;

import com.anyi.algorithm_base.chapter3.TreeNode;

/**
 * 求出从根节点出发，到叶节点，求出最大权重路径
 */
public class Code7_MaxSumTree {
    public static int maxWeight = Integer.MIN_VALUE;
    public static void maxSumTree(TreeNode root,int weight){
        if(root.left == null && root.right == null){
             Math.max(maxWeight,weight+ root.value);
        }
        if(root.left !=null){
            maxSumTree(root.left,weight + root.value);
        }
        if(root.right != null){
            maxSumTree(root.right,weight + root.value);
        }
    }
}
