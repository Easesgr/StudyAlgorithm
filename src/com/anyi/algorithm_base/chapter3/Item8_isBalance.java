package com.anyi.algorithm_base.chapter3;

/**
 * 判断一棵树是不是平衡树
 * 平衡树就是每颗子树的左树和右数的层次差值没有超过1
 */
public class Item8_isBalance {
    public static boolean isBalanced(TreeNode root){
        return isBalance(root).isBalance;
    }

    public static info isBalance(TreeNode root){
        // base条件
        if(root == null){
            return new info(true,0);
        }
        info leftData = isBalance(root.left);
        info rightData = isBalance(root.right);
        // 组装本节点需要返回的信息
        int level = Math.max(leftData.level,rightData.level) + 1;
        boolean isBalance = Math.abs(leftData.level - rightData.level) <= 1;
        return new info(isBalance,level);
    }

    // 返回的信息
    public static class info{
        boolean isBalance;
        int level;
        public info(boolean isBalance,int level){
            this.isBalance = isBalance;
            this.level = level;
        }
    }
}
