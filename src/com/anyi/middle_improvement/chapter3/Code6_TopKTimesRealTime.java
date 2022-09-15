package com.anyi.middle_improvement.chapter3;

import java.util.*;

/**
 * 给你一组字符串，返回其中出现次数前k个的字符串序列。
 */
public class Code6_TopKTimesRealTime {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res.add("abc");
        res.add("abc");
        res.add("bcc");
        res.add("bcc");
        res.add("aaa");
        res.add("bcc");
        PriorityQueue<Node> nodes = TopTimesRealTime(res, 3);
        System.out.println("1 "+ nodes.poll().times);
        System.out.println("2 "+ nodes.poll().times);
        System.out.println("3 "+ nodes.poll().times);
    }
    public static class Node {
        public String str;
        public int times;
        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }
    public static PriorityQueue<Node> TopTimesRealTime(List<String> list, int k){
        // 先用hashmap统计出现次数
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : list) {
            if(!map.containsKey(s)){ // 不存在直接加入
                map.put(s,1);
            }else{
                map.put(s,map.get(s) + 1); //存在在原理的基础上加一
            }
        }
        // 准备一个大跟堆
        PriorityQueue<Node> res = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.times - o1.times;
            }
        });
        // 将所有的元素加入到大跟堆
        Set<String> strings = map.keySet();
        for(String str:strings){
            res.add(new Node(str,map.get(str)));
        }
        return res;
    }
}
