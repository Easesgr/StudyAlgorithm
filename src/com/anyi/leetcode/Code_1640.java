package com.anyi.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Code_1640 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        //使用map存储头节点信息
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int[] piece : pieces){
            map.put(piece[0],piece);
        }
        // 从头开始遍历
        for(int i = 0; i < arr.length; i++){
            // 查找头
            if(map.containsKey(arr[i])){
                int[] temp = map.get(arr[i]);
                for(int j = 0; j < temp.length; j ++,i++){
                    if(temp[j] != arr[i]){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
