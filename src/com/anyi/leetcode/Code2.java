package com.anyi.leetcode;

class Code2 {
    public static void main(String[] args) {

    }
    public static int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j< nums.length; j++){
                swap(nums,i,j);
                maxNum = Math.max(maxNum,Integer.parseInt(new String(nums)));
                swap(nums,i,j);
            }
        }
        return maxNum;
    }
    public static void swap(char[] nums ,int i , int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}