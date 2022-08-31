package com.anyi.algorithm_base.chapter3;

/**
 * 判断一棵树是不是满二叉树
 */
public class Item7_isFull {
    public static boolean isFullRes(TreeNode root){
        info info = isFull(root);
        if (info.numbers == (1 << info.level ) -1){
            return true;
        }
        return false;
    }
    // 采用树形dp的方法
    public static info isFull(TreeNode root){
        // base条件
        if (root ==null){ // 返回 null
            return new info(true,0,0);
        }
        info leftData = isFull(root.left);
        info rightData = isFull(root.right);

        int level = Math.max(leftData.level,rightData.level) + 1;

        int numbers = leftData.numbers + rightData.numbers + 1;

        boolean isFull = leftData.isFull && rightData.isFull;

        return new info(isFull,level,numbers);
    }
    public static class info{
        boolean isFull;
        int level;
        int numbers;
        public info(boolean full, int level,int numbers){
            this.isFull = full;
            this.level = level;
            this.numbers = numbers;
        }
    }
}
