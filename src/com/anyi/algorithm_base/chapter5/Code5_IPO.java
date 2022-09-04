package com.anyi.algorithm_base.chapter5;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一些数对，第一个数是投资资金，第二个数是投资后可以获益，求给你某一资金最大能获得多少利益
 */
public class Code5_IPO {
    /**
     * 思路： 让所有的数都进入一个小根堆，以当前金额来解锁能够投资的项目放到以大根堆里面，解锁后，每次从大根堆里面弹出一个，
     *       直到到达最大投资数，或者没有可以投资的项目
     */
    public static class Node{
        public int capital; // 本金
        public int profit; // 利益

        public Node(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public static class MinComparator implements Comparator<Node> { // 按照本金小的排序
        @Override
        public int compare(Node o1, Node o2) {
            return o1.capital - o2.capital;
        }
    }
    public static class MaxComparator implements Comparator<Node>{ // 按照利益大的排序

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }
    public static int IPO(int[][] arr,int capital,int k){
        // 数据装换称node
        PriorityQueue<Node> maxQueue = new PriorityQueue<>(new MaxComparator());
        PriorityQueue<Node> minQueue = new PriorityQueue<>(new MinComparator());
        for (int i = 0; i < arr.length; i++) {
            minQueue.add(new Node(arr[i][0],arr[i][1]));
        }
        for (int i = 0; i < k; i++) { // 需要投资k次，每次投资前将能够投资项目加到投资项目中
            while (!minQueue.isEmpty() && minQueue.peek().capital <= capital){
                maxQueue.offer(minQueue.poll());
            }
            if(maxQueue.isEmpty()){
                return capital;
            }
            capital += maxQueue.poll().profit;
        }
        return capital;
    }
}
