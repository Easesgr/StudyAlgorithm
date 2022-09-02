package com.anyi.algorithm_base.chapter4;

import java.util.*;

/**
 * 最小生成树 k算法 Kruskal
 */
public class Code4_Kruskal {

    public static Set<Edge> kruskal(Graph graph){
        Map<Node, List<Node>> map = generate((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // 遍历所有的边
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> res =new HashSet<>();
        // 出队列
        while (!priorityQueue.isEmpty()){
            Edge poll = priorityQueue.poll();
            if(!isSame(map,poll.from,poll.to)){ // 如果起始和结束节点是一个，不要，不是一个节点，说明没够成环，接着收入
                res.add(poll);
                union(map,poll.from,poll.to);
            }
        }
        return res;
    }



    // 需要一个hash来储存当前节点的属于哪个一个集合
    public static Map<Node,List<Node>> generate(List<Node> nodes){
        HashMap<Node, List<Node>> res = new HashMap<>();
        for (Node node : nodes) {
            List<Node> list = new ArrayList<>();
            list.add(node);
            res.put(node,list);
        }
        return res;
    }
    // 比对是不是同一个集合
    public static Boolean isSame( Map<Node, List<Node>> res,Node from ,Node to){
        List<Node> fromNodes = res.get(from);
        List<Node> toNodes = res.get(to);
        return toNodes == fromNodes;
    }
    // 合并两个集合
    public static void union( Map<Node, List<Node>> res,Node from ,Node to){
        List<Node> fromNodes = res.get(from);
        List<Node> toNodes = res.get(to);
        for (Node toNode : toNodes) {
            fromNodes.add(toNode);
        }
        res.put(to,fromNodes); // 让到达节点集合指向现在所有集合
    }

    private static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
