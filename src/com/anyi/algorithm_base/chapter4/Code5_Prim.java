package com.anyi.algorithm_base.chapter4;

import java.util.*;

/*
    图的最小生成树 p算法 Prim
    思路： 随机选一个节点放进小根队列，第一个节点加入，将它的所有边加到队列当中
          然后弹出最小边，找到对应的to节点，如果它不在返回已经遍历的结合中，将它的边全部进队列
          持续弹出最小边，最后获得所有返回的边;
 */
public class Code5_Prim {
    private static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    public static Set<Edge> primMST(Graph graph){
        // 准备一个小根队列
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // 遍历过的节点
        Set<Node> set = new HashSet<>();
        // 返回结果
        Set<Edge> res = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
            }
            while (!priorityQueue.isEmpty()){
                Edge poll = priorityQueue.poll(); // 弹出最小边
                Node to = poll.to;
                if (!set.contains(to)){
                    set.add(to);
                    res.add(poll);
                    for (Edge edge : to.edges) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }
        return res;
    }
}
