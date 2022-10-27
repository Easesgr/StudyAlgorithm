package com.anyi.leetcode;

public class Code_209 {
    public static void main(String[] args) {
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int left = 0;
        int right = 0;
        int preNum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right <= nums.length){
            if(preNum >= target){
                minLen = Math.min(minLen,right-left);
                preNum -= nums[left++];
            }else if(right == nums.length){
                if(preNum > target){
                    preNum-= nums[left++];
                }else{
                    break;
                }
            }else if(preNum < target){
                preNum+=nums[right++];
            }else if(preNum > target){
                preNum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}
