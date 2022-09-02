package com.anyi.algorithm_base.chapter1;

import java.util.*;

public class Item6_CakeSort {
    static List<Integer> res = new ArrayList<>();
    static List<Integer> res1 = new ArrayList<>();
    // 每次找到最大值，然后反转到最前面，最经历一次往最后反转
    public static List<Integer> pancakeSort(int[] arr) {

        int n = arr.length;
        while(n > 0){
            int index = 0;
            index = getMaxRange(arr,n);
            if (index == n){
                continue;
            }
            // 将当前坐标之前的进行反转
            reserve(arr,index);// 当前节点以前全部反转
            reserve(arr,n-1);
            res.add(index + 1);
            res.add(n);
            n--;
        }
        return res;
    }
    public static int getMaxRange(int[] arr, int len){
        int index = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < len ; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
    // 反转len以前列表
    public static void reserve(int[] arr,int len){
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while(cur <= len){
            stack.push(arr[cur]);
            cur ++;
        }
        cur = 0;
        while(!stack.isEmpty()){
            arr[cur] = stack.pop();
            cur ++;
        }
    }
}
