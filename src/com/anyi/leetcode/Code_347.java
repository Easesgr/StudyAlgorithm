package com.anyi.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Code_347 {
    public static void main(String[] args) {
        topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // 统计频率加小根堆
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0 ; i < n ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        // 创建小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override   
            public int compare(int[] o1,int[] o2){ // 根据频率排序
                return o1[1] - o2[1];
            }

        });
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(heap.size() == k){
                if(value > heap.peek()[1]){
                    heap.poll();
                    heap.offer(new int[]{key,value});
                }
            }else{
                heap.offer(new int[]{key,value});
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = heap.poll()[0];
        }
        return ans;
    }
}