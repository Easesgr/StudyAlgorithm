package com.anyi.algorithm_base.chapter3;

/**
 * 判断一个树是不是搜索树
 * 搜索树特点：左 > 头 > 右
 */
public class Item5_isBST {


    public static int preValue =  0;
    // 采用中序遍历实现，如果是搜索树，那么中序遍历，一定是递增的
    public static boolean isBST(TreeNode root){
        if (root == null){
            return true;
        }
        isBST(root.left);
        if (preValue > root.value){
            return false;
        }else {
            preValue = root.value;
        }
        isBST(root.right);
        return true;
    }

    // 采用树形dp方式
    public static boolean isBSTDp(TreeNode root){
        // 基础条件 当 null时返回true 当为叶子节点的时候也返回ture
        if (root == null || (root.left == null && root.right ==null)){
            return true;
        }
        boolean leftData = isBSTDp(root.left);
        boolean rightData = isBSTDp(root.right);
        // 本节点需要返回的信息
        if(!leftData || !rightData || root.value < root.left.value || root.value > root.right.value){
            return false;
        }
        return true;
    }
}
