package com.anyi.algorithm_base.chapter4;

/**
 * 图的边
 */
public class Edge {
    public int weight; // 权重或路长
    public Node from; // 出发节点
    public Node to; // 到达节点
    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from  = from;
        this.to = to;
    }
}
