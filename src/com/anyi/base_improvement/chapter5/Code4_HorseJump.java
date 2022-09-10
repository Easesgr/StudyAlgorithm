package com.anyi.base_improvement.chapter5;


/**
 * 马踏棋盘，从某一个位置（x,y），通过k步到达（i,j） 有多少种方法
 */
public class Code4_HorseJump {
    public static void main(String[] args) {
        int i = horseJump(6, 7, 10);
        int i1 = horseJump1(6, 7, 10);
        System.out.println(i == i1);
    }
    // 在一个 9 * 10 的棋盘中
    // 从（0,0） -> (x,y) 走 step步
    public static int horseJump(int x,int y,int step){
        if(x < 0 || x > 8 || y < 0 || y > 9 ){
            return 0;
        }
        if(step == 0){
            return (x== 0 && y == 0)? 1:0;
        }
        // 所有方向相加的和
        return horseJump(x + 2,y + 1,step -1)+
                horseJump(x -2,y + 1,step -1)+
                horseJump(x + 1,y + 2,step -1)+
                horseJump(x + 1,y -2,step -1)+
                horseJump(x -1,y -2,step -1)+
                horseJump(x -1,y +2,step -1)+
                horseJump(x + 2,y -1,step -1)+
                horseJump(x - 2,y -1,step -1);
    }
    // 改成动态规划
    public static int horseJump1(int x, int y,int step){
        if(x < 0 || x > 8 || y < 0 || y > 9){
            return 0;
        }
        // 三个变量
        int[][][] dp  = new int[9][10][step +1];
        // 初始化条件
        for(int i = 0 ; i< 9 ;i ++){

        }
        // j
       for(int h = 1; h <= step; h++){
           for(int i = 0 ; i < 9; i++){
               for(int j = 0; j< 10; j++){
                   dp[i][j][h] += getValue(dp,i +2, j +1,h-1);
                   dp[i][j][h] += getValue(dp,i -2,j +1,h-1);
                   dp[i][j][h] +=  getValue(dp,i +1,j +2,h-1);
                   dp[i][j][h] +=  getValue(dp,i +1,j -2,h-1);
                   dp[i][j][h] +=  getValue(dp,i -1,j -2,h-1);
                   dp[i][j][h] +=  getValue(dp,i -1,j +2,h-1);
                   dp[i][j][h] +=  getValue(dp,i +2,j -1,h-1);
                   dp[i][j][h] +=  getValue(dp,i -2,j -1,h-1);
               }
           }
       }
       return dp[x][y][step];
    }
    public static int getValue(int[][][] dp ,int i,int j,int step){
        if(i < 0 || i > 8 || j < 0 || j > 9){
            return 0;
        }
        return dp[i][j][step];
    }
}
