package com.anyi.base_improvement.chapter5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
    机器人走路，给你一个1-N的数组，给你一个当前机器人的位置cur,给你一个目标位置target，
    然后指定K步数到达目标位置，请问有多少种方法到达目标位置
 */
public class Code1_RobotWalk {
    public static void main(String[] args) {
        int i = process3(10, 6, 2, 10);
        System.out.println(i);
    }

    // 给定N，从当前cur到达target，走k步，请问有多少种方法
    public static int process1(int N,int target,int cur,int steps){
        return f(N,target,cur,steps);
    }
    public static int f(int N,int target,int cur,int steps){
        if(steps == 0){ // 返回条件
            return target == cur ? 1:0;
        }
        if (cur == 1){ // 左边界，只能往右走
            return f(N,target,2,steps - 1);
        }
        if (cur == N){ // 右边界只能往左走
            return f(N,target,N - 1,steps -1);
        }
        // 可以往两边走
        return f(N,target,cur - 1,steps - 1) // 往左走一步
                + f(N,target,cur + 1,steps - 1); // 往右走一步
    }
    // 采用记忆数组进行优化
    public static int process2(int N,int target,int cur,int steps){
        // 准备一个缓存数组，将所有位置都变成0
        int[][] dp = new int[N +1][steps + 1];
        for(int i =0 ; i <= N ; i++){
            for (int j = 0; j<=steps; j++){
                dp[i][j] = -1;
            }
        }
        return f2(N,target,cur,steps,dp);
    }


    // 记忆数组查询
    public static int f2(int N,int target,int cur,int steps,int[][] dp){
        if(dp[cur][steps] != -1){ // 缓存命中
            return dp[cur][steps];
        }
        // 缓存没命中，返回信息
        if(steps == 0){ // 返回条件
            dp[cur][steps] = cur == target ? 1: 0;
            return dp[cur][steps];
        }
        if (cur == 1){ // 左边界，只能往右走
            dp[cur][steps] = f(N,target,2,steps - 1);
        }else if (cur == N){ // 右边界只能往左走
            dp[cur][steps] = f(N,target,N - 1,steps -1);
        }else {
            dp[cur][steps] = f(N, target, cur - 1, steps - 1)
                    + f(N, target, cur + 1, steps - 1); // 将上左边
        }
        return dp[cur][steps];
    }


    /*
     改成严格表结构
     1. 确定变量个数
     2. 构建表大小
     3. 确定目标位置
     4. 根据base初始化表
     5. 确定方向，以及根据表确定当前值应该等于什么值
     6. 返回目标位置的值
     */
    public static int process3(int N,int target,int cur,int steps){
        return f3(N,target,cur,steps);
    }
    public static int f3(int N ,int target,int cur,int steps){
        // 构建表大小、
        int[][] dp = new int[steps +1][N + 1];
        // 根据base初始化值
        dp[0][target] = 1;
        for(int step = 1; step < dp.length ; step++){ // step从 1 开始一直到5
            for(int c = 1 ; c < dp[0].length ;c++){
                if (c == 1){ // 左边界，只能往右走
                    dp[step][c] =  dp[step - 1][2]; // 从有上方拿值
                }else if (c == N){ // 右边界只能往左走
                    dp[step][c] = dp[step -1][N-1];
                }else {
                    dp[step][c] = dp[step -1][c -1]+
                            + dp[step - 1][c + 1]; // 将上左边
                }
            }
        }
        return dp[steps][cur];
    }

}
