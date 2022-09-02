package com.anyi.algorithm_base.chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 图
 */
public class Graph {
    // 以值为键，当前
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph (){};

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
