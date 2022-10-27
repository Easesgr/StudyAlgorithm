package com.anyi.leetcode;

public class Code_300 {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    public static int lengthOfLIS(int[] nums) {
        // 动态规划
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
