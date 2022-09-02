package com.anyi.algorithm_base.chapter4;

import java.util.*;

/**
 * 图的深度DFS遍历
 */
public class Code2_DFS {
    public static List<Node> dfs(Node head){
        List<Node> res = new ArrayList<>();
        // 准备一个栈,和一个保证不重复遍历的set
        Stack<Node> stack =new Stack<>();
        Set<Node> set =new HashSet<>();
        // 让第一个数进栈
        stack.push(head);
        res.add(head);
        set.add(head);
        while(!stack.isEmpty()){ // 栈不为空
            Node pop = stack.pop();
            // 遍历所有的节点，找到第一个节点
            for (Node next : pop.nexts) {
                if (!set.contains(next)){
                    res.add(next);
                    set.add(next);
                    // 将当前出栈节点和下一个节点压栈
                    stack.push(pop);
                    stack.push(next);
                    break; // 找到一个节点就往下走 剩下没有遍历到的节点将会在退栈得时候继续压栈
                }
            }
        }
        return res;
    }
}
