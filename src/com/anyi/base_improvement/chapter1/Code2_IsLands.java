package com.anyi.base_improvement.chapter1;

/**
 * 查询有几个岛,给定一个二维数组，如果二维数组，判断当前二维数组有几个岛，所有是1的连起来，总共有几个岛
 */
public class Code2_IsLands {
    public static void main(String[] args) {
        int[][] loads = new int[][]{
                {1,0,0,0,0},
                {1,1,1,0,1},
                {1,0,1,0,1},
                {0,1,0,0,0}
                };
        int landsNums = getLandsNums(loads);
        System.out.println(landsNums);
    }
    public static int getLandsNums(int[][] loads){
        int rows  = loads.length;
        int cols = loads[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(loads[i][j] == 1){
                    infect(loads,i,j,rows,cols);
                    res ++;
                }
            }
        }
        return res;
    }
    public static void infect(int[][] loads,int i, int j, int rows, int cols){
        if(i >= rows || i < 0 || j >= cols || j < 0 || loads[i][j] != 1){
            return;
        }
        loads[i][j] = 2;
        infect(loads,i + 1,j,rows,cols);
        infect(loads,i,j+1,rows,cols);
        infect(loads,i-1,j,rows,cols);
        infect(loads,i,j-1,cols,rows);
    }
}
