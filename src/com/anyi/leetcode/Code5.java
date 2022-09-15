package com.anyi.leetcode;

import java.util.Arrays;

/**
 * 数组的最长序列
 */
class Code5 {
    public static void main(String[] args) {
        longestConsecutive(new int[]{1,2,0,1});
    }
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int len = delete(nums);
        int maxIndex = 0;
        int index = 1;
        for(int i = 0; i < len ;i++){
            if(nums[i]+ 1 == nums[i+1]){
                index++;
            }else{
                index = 1;
            }
            maxIndex = Math.max(index,maxIndex);
        }
        return maxIndex;
    }
    public static int delete(int[] nums){
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[slow] < nums[fast]){
                nums[++slow] = nums[fast++];
            }else{
                fast++;
            }
        }
        return slow;
    }
}