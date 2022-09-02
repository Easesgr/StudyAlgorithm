package com.anyi.algorithm_base.chapter4;

import java.util.*;

/**
 * 图的广度优先遍历 BFS
 */
public class Code1_BFS {
    public static List<Node> bfs(Node head){ // 从某一个节点开始广度遍历
        /*
            采用队列来实现，同时注意不要重复遍历，准备一个set记录遍历过的值
        */
        List<Node> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(head);
        set.add(head);
        while (!queue.isEmpty()){
            Node poll = queue.remove(); // 出队一个
            res.add(poll);
            // 让所有相邻的节点进队
            for (Node next : poll.nexts) {
                if (!set.contains(next)){
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
