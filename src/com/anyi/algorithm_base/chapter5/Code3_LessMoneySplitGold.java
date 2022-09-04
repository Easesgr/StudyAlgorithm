package com.anyi.algorithm_base.chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 分黄金问题，将 60 分成 10 ，20 ，30 的块数，每次切都需要当前尽快的大小的钱，求最小值
 */
public class Code3_LessMoneySplitGold {
    /*
    思路：采用一个栈，让所有元素进入一个小根队列，让所有人进队，每次弹出两个，相加，哈夫曼树问题
     */
    public static int lessMoneySplitGold(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int cur = 0;
        int sum = 0;
        while(queue.size() > 1){
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
    public static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; // 小于0 升序 大于0 降序
        }
    }

}
