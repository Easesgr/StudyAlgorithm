package com.anyi.algorithm_base.chapter5;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 也是一个大根堆和小根堆的应用 ，左边维护一个大根堆，右边维护一个小根堆
 * 想让第一个数进入小根堆，下一个数到来的时候，如果他小于大根堆顶，就让它进大跟堆
 * 检查两个大小是否相差2，相差2，就从大的那一堆里面拿出一个放到小那边
 * 持续这样维护的堆顶就是那中位数
 */
public class Code6_MadianQuick {
    public static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        } // 按照本金小的排序

    }
    public static class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        } // 按照利益大的排序


    }
    public static int madianQuick(int[] arr){
        if(arr == null){
            return 0;
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new MaxComparator());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new MinComparator());
        minQueue.add(arr[0]);
        for (int i = 1 ;i< arr.length; i++){
            if (arr[i] <= minQueue.peek()){
                minQueue.add(arr[i]);
            }else {
                maxQueue.add(arr[i]);
            }
            if(Math.abs(minQueue.size() - maxQueue.size()) > 1){
                if (maxQueue.size() > minQueue.size()){
                    minQueue.add(maxQueue.poll());
                }else {
                    maxQueue.add(minQueue.poll());
                }
            }
        }
        return (minQueue.size() + maxQueue.size()) %2 == 1 ? maxQueue.peek(): (minQueue.peek() +maxQueue.peek())>>1;
    }
}
