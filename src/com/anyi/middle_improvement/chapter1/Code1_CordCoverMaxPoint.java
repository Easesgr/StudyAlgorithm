package com.anyi.middle_improvement.chapter1;


/*
  * 给你正数n作为绳子，给你一个数组，数组的每个值表示长度，这个为n的绳子最多可以包含多少个点
  * 采用一个左右指针，或者类似于滑动窗口的原理
 */
public class Code1_CordCoverMaxPoint {
    public static void main(String[] args) {
        int i = cordCoverMaxPoint(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(i);
    }
    public static int cordCoverMaxPoint(int[] arr ,int n){
        int left =0,right =0;
        int res= 0;
        int maxNum = Integer.MIN_VALUE;
        while(right != arr.length){
            if(arr[right] > n){
                break;
            }
            if(res < n){
                res += arr[right++]; // 不大于一直往前走
            }else{ // 如果大于，额
                maxNum = Math.max(maxNum,right - left-1) ; // 最左边一个不算
                while(res >= n){ // 减掉前面的数，使当前res值小于n，继续往后框
                    res-= arr[left++];
                }
            }
        }
        return maxNum;
    }
}
