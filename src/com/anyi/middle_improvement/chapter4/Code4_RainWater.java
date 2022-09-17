package com.anyi.middle_improvement.chapter4;

/**
 * 接雨水问题，给你数组，每个值表示一个矩阵，矩阵之间的间隙，可以接下雨水，请问总共可以接多少雨水
 */
public class Code4_RainWater {
    public static int trap(int[] height) {
        /*
         从左边往右边遍历，左边计算了的值就往左走一格，右边计算了就往左走一个
         计算的时候，那边值最大值更小就先计算那边的
         */
        int all = 0;
        int left = 0;
        int leftMaxNum = height[0];
        int right = height.length -1;
        int rightMaxNum =height[height.length -1];
        while(left < right){
            // 判断当前最大值，左边小还是右边小
            if(rightMaxNum > leftMaxNum){
                all += Math.max((leftMaxNum - height[left]),0);
                left++;
                leftMaxNum = Math.max(leftMaxNum,height[left]);
            }else{
                all += Math.max((rightMaxNum - height[right]),0);
                right--;
                rightMaxNum = Math.max(rightMaxNum,height[right]);
            }
        }
        return all;
    }
}