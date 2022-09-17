package com.anyi.middle_improvement.chapter6;


import com.anyi.algorithm_base.chapter3.TreeNode;

/**
 * 计算出一颗完全二叉树的节点个数
 */
public class Code4_CompleteTreeNodeNumber {
    /*
        先求出高度h，每次求右树的最左节点是否到了最后一层，如果到了，说明做左树高度层是满的，直接等于 2**h + 右树
        如果没有到达最后一层，那说明有数的level是满的，直接就是 2**level +左树
        持续这样遍历下去，就找到了所有的节点
     */
    public static int completeTreeNodeNumber(TreeNode root){
        if(root == null){
            return 0;
        }
        return process(root,1,mostLeftLevel(root,1));

    }
    public static int process(TreeNode root,int level,int h){
        if(h == level){ // 如果走到了底就返回
            return 1;
        }
        if(mostLeftLevel(root.right,level + 1) == h){
            return 1 <<(h - level) + process(root.right,level +1,h);
        }else{
            return 1 <<(h -level -1) + process(root.left,level + 1,h);
        }
    }
    public static int mostLeftLevel(TreeNode root,int level){
        while(root !=null){
            level++;
            root = root.left;
        }
        return level;
    }
}
