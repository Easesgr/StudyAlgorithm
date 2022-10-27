package com.anyi.leetcode;

import com.sun.imageio.plugins.common.I18N;

import java.util.HashMap;
import java.util.Map;

public class Slove1 {
    public static void main(String[] args) {
        System.out.println(needTime());
    }

    public int maxOnlineNum(int[][] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] p : arr){
            for(int i = p[0]; i< p[1] ;i++){
                map.put(i,map.getOrDefault(i,0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer time = entry.getKey();
            Integer value = entry.getValue();
            if(value > max){
                max = time;
            }
        }
        return max;
    }
    public static int needTime(){
        int cur = 1000,curMonth = 1,sum =1000;
        while(sum < 300000){
            sum = sum + cur;
            cur += 1000;
            curMonth ++;
            if(curMonth % 12 == 1){
                cur = 1000 + curMonth /12 * 1000;
            }
        }
        return curMonth;
    }
}
