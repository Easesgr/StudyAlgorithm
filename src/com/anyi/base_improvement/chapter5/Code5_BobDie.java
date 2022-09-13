package com.anyi.base_improvement.chapter5;

import java.math.BigDecimal;

/**
 * bob在一个n*n的棋盘中，目前处于（x,y）位置，可以往上下左右四个方向走
 * 走k步后，如果走出棋盘，就是死了，如果还在棋盘中就活着，求bob活着的概率
*/

public class Code5_BobDie {

    public static void main(String[] args) {
        long gcd = gcd(10, 100);
        long n1= 1;
        long n2= 16;
        BigDecimal res = new BigDecimal(1);
        res.divide(new BigDecimal(1));
        Double aDouble = new Double(String.valueOf(res));
        System.out.println((double) n1/(double) n2);
        int i = bobDie(10, 6, 7, 10);
        int total = 2<< 2*10;
        System.out.println(i/total);
        int i1 = bobDie2(10, 6, 7, 10);
        System.out.println(i1);
    }

    // 递归
    public static int bobDie(int n ,int x, int y,int k){
        if(x < 0|| x == n || y < 0 || y ==n){
           return 0;
        }
        if(k ==0 ){
            return 1;
        }
        return bobDie(n,x-1,y,k-1)+
                bobDie(n,x,y-1,k-1)+
                bobDie(n,x+1,y,k-1)+
                bobDie(n,x,y+1,k-1);
    }

    public static long gcd(long m,long n){
        return n==0?m:gcd(n,m%n);
    }
    // 动态规划dp
    public static int bobDie2(int n ,int x, int y, int k){
        int[][][] dp =new int[k+1][n+2][n+2];
        for (int i= 0 ; i <= n; i++){ // base case 初始化
            for(int j = 0; j<= n;j++){
                dp[0][i][j] = 1;
            }
        }
        for(int h = 1; h<=k ; h++){
            for(int r = 0; r <= n; r++){
                for(int c= 0; c <=n;c++){
                    dp[h][r][c] += getValue(n,dp,r-1,c,h-1);
                    dp[h][r][c] += getValue(n,dp,r+1,c,h-1);
                    dp[h][r][c] += getValue(n,dp,r,c+1,h-1);
                    dp[h][r][c] += getValue(n,dp,r,c-1,h-1);
                }
            }
        }
        return dp[k][x][y];
    }
    public static int getValue(int n,int[][][] dp,int x,int y,int h){
        if(x < 0 || x == n || y < 0 || y == n){
            return 0;
        }
        return dp[h][x][y];
    }
}

