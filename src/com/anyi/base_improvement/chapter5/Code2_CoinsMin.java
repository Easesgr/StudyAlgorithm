package com.anyi.base_improvement.chapter5;

/**
 * 给你一组数组，一个数表示一个硬币，给你一个target，找出最少硬币组成值等于target
 * 求最少几枚硬币
 */
public class Code2_CoinsMin {
    public static void main(String[] args) {
        int i = f3(new int[]{1,2,5}, 11);
        System.out.println(i);
    }
    // 暴力 递归
    public static int f1(int[] arr,int target){
        return process1(arr,target,0);
    }
    public static int process1(int[] arr,int target,int index){
        if (target < 0){
            return -1;
        }
        if (target == 0){
            return 0;
        }
        // base case
        if(index == arr.length){
           return -1;
        }
        int noNeed = process1(arr,target,index + 1);
        int need = process1(arr,target -arr[index] ,index +1);
        if (need == -1 && noNeed == -1){
            return  -1;
        }else{
            if (need == -1){
                return noNeed;
            }
            if (noNeed == -1){
                return need + 1;
            }
            return Math.min(need,noNeed);
        }
    }

    // 改成记忆缓存
    public static int f2(int[] arr,int target){
        int n = arr.length;
        int[][] dp = new int[target + 1][n + 1];
        // 初始化一下
        for(int i = 0  ; i <=target ;i++){
            for (int j = 0 ; j <= n; j++){
                dp[i][j] = -2;
            }
        }
        return process2(arr,target,0,dp);
    }
    public static int process2(int[] arr,int target,int index,int[][] dp){
        if (target < 0){
            return -1;
        }
        if (dp[target][index] != -2){
            return dp[target][index];
        }
        if (target == 0){
            dp[target][index] = 0;
        }else if(index == arr.length){
            dp[target][index] = -1;
        }else{
            int noNeed = process2(arr,target,index + 1,dp);
            int need = process2(arr,target -arr[index] ,index +1,dp);
            if (need == -1 && noNeed == -1){
                dp[target][index] = -1;
            }else{
                if (need == -1){
                    dp[target][index] = noNeed;
                }else if (noNeed == -1){
                    dp[target][index] = need + 1;
                }else {
                    dp[target][index]  = Math.min(need,noNeed);
                }
            }
        }
        return dp[target][index];
    }

    /*
    改成严格表结构
    1. 确定有几个变量
    2. 构建表，
    3. 根据base case 初始化数组
    4. 找到依赖关系
    5. 根据目标值找到方向
    */
    public static int f3(int[] arr,int target){
        return process3(arr,target);
    }
    public static int process3(int[] arr,int target){
        int n = arr.length;
        // 构建表
        int[][] dp = new int[n +1][target + 1];
        for(int i = 0;i <= n ; i++){
            dp[i][0] = 0;
        }
        for(int i = 1 ; i <= target; i++){
            dp[n][i] = -1;
        }
        for(int i = n - 1; i >= 0 ;i--){
            for (int j = 1  ; j <= target; j++){
                int p1 = dp[i + 1][j];
                int p2Next = -1;
                if(j -arr[i] >=0){
                    p2Next = dp[i + 1][j -arr[i]];
                }
                if (p2Next == -1 && p1 == -1){
                    dp[i][j] = -1;
                }else{
                    if (p1 == -1){
                        dp[i][j] =  p2Next + 1;
                    }else if (p2Next == -1){
                        dp[i][j] = p1;
                    }else {
                        dp[i][j] = Math.min(p2Next + 1,p1);
                    }
                }
            }
        }
        return dp[0][target]; // 返回index从1开始，target = 8 的个数
    }

}
