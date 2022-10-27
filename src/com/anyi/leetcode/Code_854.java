package com.anyi.leetcode;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Code_854 {
    public static void main(String[] args) {
        int i = kSimilarity("abccaacceecdeea", "bcaacceeccdeaae");
        System.out.println(i);
    }
    public static int kSimilarity(String s1, String s2) {
        /**
         从0开始找，如果前面相等，直接往后走，直到不相等n，
         从n + 1 开始找等于n的字符，然后让字符串交换的,
         判断是不是之前已经交换过的，交换过的不放入集合中
         */
        int step = 0;
        Set<String> visit = new HashSet<String>();
        if(s1.equals(s2)){
            return step;
        }
        Queue<Pair> queue = new LinkedList<>(); // 队列来进行广度优先搜索
        Pair<String,Integer> pair = new Pair(s1,0); // s1从0位置开始不一样
        queue.offer(pair);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Pair<String,Integer> poll = queue.poll(); // 取出队头元素
                String cur = poll.getKey(); // 当前字符串
                Integer pos = poll.getValue(); // 当前位置
                if (cur.equals(s2)) {
                    return step;
                }
                while(pos < cur.length() && cur.charAt(pos) == s2.charAt(pos)){
                    pos++; // 相等位置不交换
                }
                // 找到一个不相等的位置，从 pos + 1 位置往后找一个数字，和当前pos位置相等的交换
                for(int j = pos + 1; j < cur.length(); j++){
                    if(cur.charAt(j) == s2.charAt(j)){
                        continue;
                    }
                    if(cur.charAt(j) == s2.charAt(pos)){
                        String next = swap(cur,pos,j);
                        if(!visit.contains(next)){
                            visit.add(next);
                            queue.offer(new Pair(next,pos + 1)); // pos + 1 位置是无序的
                        }
                    }
                }
            }
            step++; // 做完上面的步骤，一定已经将一个位置移动好了，
        }
        return step;
    }
    public static String swap(String str,int i, int j){
        char[] strs = str.toCharArray();
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
        return new String(strs);
    }
}
