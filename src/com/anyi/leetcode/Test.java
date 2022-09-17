package com.anyi.leetcode;

import java.util.*;

/**
 * 测试方法
 */
public class Test {
    public static void main(String[] args) {
        String s = "a good   example";
        String[] str = s.trim().split(" ");
        StringBuffer res = new StringBuffer();
        for(int i = str.length -1; i>0; i--){
            String temp = str[i].trim();
            res.append(temp).append(" ");
        }
        res.append(str[0]);
    }
    public static int uniquePaths(int m, int n) {
        // 先递归写一遍
        int[][] dp = new int[m][n];
        // base case 初始化基础条件
        for(int row = m-1; row >=0 ; row --){
            for(int col = n-1; col >= 0; col--){
                if(row == m-1 && col == n-1){
                    dp[row][col] =1;
                }else{
                    dp[row][col] = getValue(dp,row + 1, col) + getValue(dp,row,col +1);
                }
            }
        }
        return dp[0][0];
    }
    public static int getValue(int[][] dp , int row ,int col){
        if(row >= dp.length || col >= dp[0].length){
            return 0;
        }
        return dp[row][col];
    }
    public static String simplifyPath(String path) {
        // 采用一个栈来实现
        String[] strs = path.split("/"); // 全部分隔开
        Deque<String> stack = new ArrayDeque<>();

        for(String str:strs){
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop(); // 弹出一个
                }else{
                    continue;
                }
            }else if(str.equals(".") || str.equals("/")){
                continue;
            }else{
                stack.push(str);
            }
        }
        // 最后栈中剩下的就是最终结果
        StringBuffer res = new StringBuffer();
        while(!stack.isEmpty()){
            res.append("/");
            res.append(stack.pop());
        }
        return res.toString();
    }
}
