package com.anyi.algorithm_base.chapter3;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个不同节点 p 和 q，找出他们父节点第一个汇聚点
 */
public class Item9_parentNode {
    // 首先使用hashmap记录父节点 ，往上走的方式来实现找到汇聚点
    public static TreeNode getParentNode(TreeNode root, TreeNode p ,TreeNode q){
        TreeNode res = root;
        // map 记录节点的父节点
        Map<TreeNode,TreeNode> map =new HashMap<>();
        creatParentMap(root,map);
        // 采用hashset
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        TreeNode treeNode = map.get(p);
        while (treeNode != null){
            set.add(treeNode);
            treeNode = map.get(treeNode);
        }
        TreeNode qParent = map.get(q);
        while (qParent != null){
            if(set.contains(qParent)){
                res = qParent;
            }else {
                qParent = map.get(qParent);
            }
        }
        return res;
    }
    public static void creatParentMap(TreeNode root,Map<TreeNode,TreeNode> map){
        // 递归遍历节点
        if (root == null){
            return;
        }
        // 填写信息
        map.put(root.left,root);
        map.put(root.right,root);
        // 递归遍历
        creatParentMap(root.left,map);
        creatParentMap(root.right,map);
    }
    // 采用dp实现
    public static TreeNode getParentNodeDp(TreeNode root,TreeNode o1,TreeNode o2){
        if (root == null || root == o1 || root == o2){ // 如果碰到者三个节点直接返回
            return root;
        }
        TreeNode leftData = getParentNodeDp(root.left, o1, o2);
        TreeNode rightData = getParentNode(root.right, o1, o2);
        // 获得左右节点返回
        if(leftData != null && rightData !=null){
            return root;
        }
        return leftData != null ? leftData :rightData;
    }


}
