package com.anyi.middle_improvement.chapter1;

/**
 * 给你n个节点，请问可以构造多少种二叉树
 */
public class Code6_UniqueBST {
    public static void main(String[] args) {
        System.out.println(uniqueBST(10));
    }
    public static int uniqueBST(int n){
        if(n < 0){
            return 0;
        }
        if (n == 1 || n == 0){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        // 当前节点的左边的个数加上右边的个数
        int res = 0;
        for(int i = 0 ; i  < n ; i++){
            int left = uniqueBST(i);
            int right = uniqueBST(n-i-1);
            res += left * right;
        }
        return res;
    }

    public static int uniqueBSTDP(int n){
        if(n < 2){
            return 1;
        }
        // 只有一个变量
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < n+1; i++){ // 遍历n+1次
            for(int j = 1; j < i +1; j++){
                dp[i] += dp[j - 1] + dp[i - j];
            }
        }
        return dp[n];
    }
}
