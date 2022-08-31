package com.anyi.algorithm_base.chapter3;

import java.util.*;

/**
 *  获取二叉树的层次中最多节点数
 */
public class Item4_MaxNodes {
    // 获取二叉树的层次中最多节点数,采用hashmap
    public static int getMaxNode(TreeNode head){
        // 采用个hashmap 存储所有节点所在的层次
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(head,1); // 存储乘次信息
        int max = Integer.MIN_VALUE;

        // 采用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int curLevel = 1;
        int curLevelNodes = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.remove(); // 出队列
            if (curLevel == map.get(poll)){ // 如果当前层和节点层是一层
                curLevelNodes ++;
                max = Math.max(max,curLevelNodes);
            }else { // 如果不是一层了，将当前层和当前层节点重置
                curLevel ++;
                curLevelNodes = 1;
            }
            if (poll.left != null){
                queue.add(poll.left);
                map.put(poll.left,map.get(poll) + 1);
            }
            if (poll.right !=null){
                queue.add(poll.right);
                map.put(poll.right,map.get(poll) + 1);
            }
        }
       return max;
    }
    // 采用四个参数加队列来实现
    public static int getMaxNodesCoding(TreeNode head){
        int max = Integer.MIN_VALUE;
        TreeNode curEndNode = head;
        TreeNode nextEndNode = null;
        int curLevelNodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.remove();
            if (poll.left !=null){
                queue.add(poll.left);
                nextEndNode = poll.left;
            }
            if (poll.right !=null){
                queue.add(poll.right);
                nextEndNode = poll.right;
            }
            if (poll == curEndNode){
                curLevelNodes ++;
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEndNode = nextEndNode;
                nextEndNode =null;
            }else {
                curLevelNodes ++;
            }

        }
        return max;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 二叉树分层遍历
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root,1); // 记录当前节点是第几层
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int curLevel = 1;
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            TreeNode poll = queue.remove(); // 出队
            if(curLevel != map.get(poll)){
                res.add(list);
                list = new ArrayList<>();
                list.add(poll.value);
                curLevel ++;
            }else{
                list.add(poll.value);
            }
            if(poll.left != null){
                queue.add(poll.left);
                map.put(poll.left,curLevel + 1);
            }
            if(poll.right != null){
                queue.add(poll.right);
                map.put(poll.right,curLevel + 1);
            }
        }
        res.add(list);
        return res;
    }
}
