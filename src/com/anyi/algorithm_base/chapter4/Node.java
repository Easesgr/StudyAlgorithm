package com.anyi.algorithm_base.chapter4;



import java.util.ArrayList;
import java.util.List;

/**
 * 图的node节点
 */

public class Node {
    public int val; // 节点值1
    public int out; // 出度
    public int in; // 入度
    public List<Node> nexts; // 当前节点的所有直连节点
    public List<Edge> edges; // 当前节点所有的直连边

    public Node(int val) {
        this.val = val;
        this.out = 0;
        this.in = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
