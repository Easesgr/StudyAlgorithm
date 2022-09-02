package com.anyi.algorithm_base.chapter4;

/**
 * 通过二维数组生成图
 * [
 * [1,3,2] // 表示 1 - > 2  权重为 3
 * [2,5,3] // 表示 2 - > 3  权重为 5
 * ]
 */
public class GenerateGraph {
    public static Graph generate(int[][] data){
        // 创建一张表
        Graph graph = new Graph();
        for (int i = 0; i < data.length ; i++){
            Node from = new Node(data[i][0]); // 出发节点
            Node to = new Node(data[i][2]); // 到达节点
            Edge edge = new Edge(data[i][1],from,to);
            graph.edges.add(edge);
            // 对节点信息进行改变
            from.nexts.add(to);
            from.edges.add(edge);
            from.out ++;
            to.in ++;
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from.val,from);
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to.val,to);
            }
        }
        return graph;
    }
}
