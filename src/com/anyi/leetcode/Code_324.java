package com.anyi.leetcode;

import java.util.Arrays;

public class Code_324 {
    public static void main(String[] args) {
        wiggleSort(new int[]{1,5,1,1,6,4});
    }
    public static void wiggleSort(int[] nums) {
        // 保证每三个字符都是起伏状态
        int[] arr = nums.clone(); // 克隆数组
        Arrays.sort(arr);
        int n = arr.length;
        int mid = (n + 1) / 2;
        for(int i = 0,j = mid - 1,k = n - 1; i < n; j--,k--,i+=2){
            nums[i] = arr[j];
            if(i + 1 < n){
                nums[i + 1] = arr[k];
            }
        }
    }
}