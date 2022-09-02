package com.anyi.algorithm_base.chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 图的最短路径问题
 * 思路：准备一个map来存储每个节点到起始节点长度
 *      准备一个锁定列表，如果选中节点被遍历完了，就锁定
 *      每次寻找最小的点，并且没有被锁定的点，持续这样去更新map，直到所有的点都被更新完
 */
public class Code6_MinRoute {
    public static Map<Node,Integer> minRoute(Node head){ // 从一个节点开始
        // map存储需要更新的信息
        Map<Node, Integer>  map = new HashMap<>();
        // 准备一个锁定列表
        Set<Node> isLock = new HashSet<>();
        map.put(head,0);
        Node minNode = getIsNotLockAndMin(map, isLock);
        while (minNode !=null){
            int distance = map.get(minNode);
            // 遍历所有的边
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                if (!map.containsKey(to)){
                    // 如果这条边不在map中就加入进去，前面节点到最初点节点值加上当前边的值，等于到前节点到最初点的值
                    map.put(to,edge.weight + distance);
                }else {
                    // 如果存在，说明前面已经有到该  点的值了，就让之前到该店的值和当前点到该店的值加上边的值相比较取小的
                    map.put(to,Math.min(distance + edge.weight,map.get(to)));
                }
            }
            isLock.add(minNode);// 经过上面的边更新后，这个节点可以被锁定了
            minNode = getIsNotLockAndMin(map, isLock);
        }
        return map;
    }
    // 找到map中边最小，并且没有被锁定的节点
    public static Node getIsNotLockAndMin(Map<Node ,Integer> map, Set<Node> isLock){
        int min = Integer.MIN_VALUE;
        Node res = null;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : map.entrySet()) {
            Node key = nodeIntegerEntry.getKey(); // 键
            Integer value = nodeIntegerEntry.getValue(); //值
            if (min <value){
                min = value;
                res = key;
            }
        }
        return  res;
    }
}
