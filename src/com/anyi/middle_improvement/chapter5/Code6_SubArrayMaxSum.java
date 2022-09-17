package com.anyi.middle_improvement.chapter5;

/**
 * 给你一个数组，求连续子数组的最大累加和
 */
public class Code6_SubArrayMaxSum {
    public static void main(String[] args) {
        subArrayMaxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    // 假设成立法
    public static int subArrayMaxSum(int[] arr){
        /*
            如果我们假设 i -> j 是最大且最长的区域
            那么从i -> j 位置相加都不可能小于0，如果小于0，那我们就可以截去前面小于0的部分，不符合
            从 ... -> i -1 位置任意位置相加到i-1都不可能>=0,不然我们就会加上这一段
         */
        int maxSum = 0;
        int tempSum = 0;
        for(int i = 0 ; i < arr.length; i++){
            tempSum += arr[i];
            maxSum = Math.max(maxSum,tempSum);
            if(tempSum < 0){
                tempSum = 0;
            }
        }
        return maxSum;
    }
}
