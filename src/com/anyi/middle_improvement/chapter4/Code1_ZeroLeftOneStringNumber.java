package com.anyi.middle_improvement.chapter4;

/**
 * 组成n个字符串，每一位只能是0或者是1，并且每个0前面必须要是1，请问n长度的字符串，有多少种方式组成
 * 1 -> "1” 或 “0" 只有 “1” 有效 1
 * 2 -> "10” “11” “01” “00” ，只有 “10” 和 "11" 有效 2
 * 3 -> 有效是3种 “111”，“101”，“110”
 */
public class Code1_ZeroLeftOneStringNumber {
    public static void main(String[] args) {
        zeroLeftOneStringNumber(10);
    }
    public static int zeroLeftOneStringNumber(int n){
        // 实际上就是一个斐波那契题
        if( n == 1 || n == 2){
            return n == 1?1:2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i< n ;i++){
            dp[i] = dp[i- 1] + dp[i-2];
        }
        return dp[n-1];
    }
}
