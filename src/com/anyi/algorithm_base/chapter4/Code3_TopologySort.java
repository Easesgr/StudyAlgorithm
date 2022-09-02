package com.anyi.algorithm_base.chapter4;

import java.util.*;

/**
 * 拓扑排序
 * 思路： 就是从所有节点中找出一个入度为 0 的节点
 *       让与它相连的所有节点和他断开联系，并且寻找新的入度为0的节点
 */
public class Code3_TopologySort {
    public static List<Node> topologySort(Graph graph){
        // 准备一个入度为0的队列和一个存放所有节点当前入度的map
        List<Node> res = new ArrayList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        // 遍历所有的节点，找出入度为0的节点
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in); // 存放入度
            if (node.in == 0){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            res.add(node); // 添加到返回
            // 将和它相连的所有节点入度 -1
            for (Node next : node.nexts) {
                inMap.put(next,inMap.get(next) -1);
                if (inMap.get(next)  == 0){
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
