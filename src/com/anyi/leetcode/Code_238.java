package com.anyi.leetcode;

public class Code_238 {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
    public static int[] productExceptSelf(int[] nums) {
        // 左右乘积列表
        int n = nums.length;
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        // 构建左乘列表
        L[0] = 1;
        for(int i = 1 ; i <= n; i++){
            L[i] = nums[i-1] *L[i-1];
        }
        R[n] = 1;
        for(int i = n-1 ; i >= 0; i--){
            R[i] = nums[i] *R[i + 1];
        }
        for(int i = 0 ; i < n; i++){
            nums[i] = R[i + 1] * L[i];
        }
        return nums;
    }
}
