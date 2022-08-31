package com.anyi.algorithm_base.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 */
public class Item6_isCBT {

    /*
       完成二叉树必须满足： 宽度遍历
            1. 不能有右节点，但没有左节点
            2. 当出现有第一个有左节点，但是没有有节点的节点后，后面的节点都必须是叶子节点，否则是不是二叉树
     */
    public static boolean isCBT(TreeNode root){
        // 宽度遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 第一个节点进队列
        queue.offer(root);
        boolean firstNode = false;
        while (!queue.isEmpty()){
            TreeNode out = queue.remove(); // 弹出节点
            // 对当前节点进行判断
            if (out.left == null && out.right !=null){
                return false;
            }
            if (firstNode && (out.right != null || out.left !=null)){
                return false;
            }
            if (out.left != null && out.right == null){ // 当出现了第一个左子树不等于null后，剩下的节点都必须是叶节点
                firstNode = true;
            }
            // 子节点进队列
            if(out.left != null){
                queue.offer(out.left);
            }
            if (out.right !=null){
                queue.offer(out.right);
            }
        }
        return true;
    }
}
