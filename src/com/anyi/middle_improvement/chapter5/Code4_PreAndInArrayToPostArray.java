package com.anyi.middle_improvement.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组 preOrder和 inOrder 生成 postOrder
 * 通过前序遍历序列和中序遍历序列，生成后续遍历序列
 */
public class Code4_PreAndInArrayToPostArray {
    public static int[] preAndArrayToPost(int[] preOrder,int[] inOrder){
        // 创建一个map存储当前中序遍历的坐标
        if(inOrder.length != preOrder.length){
            return null;
        }
        int n = preOrder.length;
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i],i);
        }
        int[] postOrder = new int[inOrder.length];
        f(preOrder,0,n-1,inMap,0,n-1,postOrder,0,n-1);
        return postOrder;
    }
    public static void f(int[] preOrder, int ps, int pe,
                         Map<Integer,Integer> inMap,int is,int ie,
                         int[] postOrder,int postS,int postEnd){
        if(ps > pe){
            return;
        }
        // 只剩一个数了直接填
        if(ps == pe){
            postOrder[postS] = preOrder[ps];
        }
        postOrder[postEnd] = preOrder[ps]; // 前序遍历的第一个 == 后续遍历的最后一个
        // 找到中点
        int pIndex = inMap.get(preOrder[ps]); // 找到头节点
        // 递归继续填
        f(preOrder,ps,ps + pIndex - is,inMap,is,pIndex -1,postOrder,postS,postS + pIndex -ps);
        f(preOrder,ps + pIndex - is,pe,inMap,pIndex +1,ie,postOrder,postEnd +pIndex - ie,postEnd);
    }
}
