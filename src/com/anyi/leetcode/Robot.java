package com.anyi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Robot {
    static List<List<Integer>> ans = new ArrayList<>();
    static int rows,cols;

    public static void main(String[] args) {
        pathWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });
    }
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        if(rows == 0){ // 空的，无法遍历
            return ans;
        }
        if(obstacleGrid[rows - 1][cols - 1] == 1){ // 右下角数字时1，无法到达
            return ans;
        }
        f(obstacleGrid,0,0);
        return ans;
    }
    public static boolean f(int[][] obstacleGrid, int x, int y){
        // 越界或者当前格子为1，或是已经被走过
        if(x >= rows || y >= cols || obstacleGrid[x][y] == 1|| obstacleGrid[x][y] == 2){
            return false;
        }
        // 可以尝试
        ans.add(new ArrayList<>(Arrays.asList(x,y)));
        obstacleGrid[x][y] = 2;
        // 如果当前已经到达了最后一个，直接返回
        if(x == rows - 1 && y == cols -1){
            return true;
        }
        // 接着往下和往右尝试
        if( f(obstacleGrid,x,y+1)|| f(obstacleGrid,x + 1,y) ){
            return true;
        }
        // 没有返回true,说明无法到达，移除当前节点
        ans.remove(ans.size() -1);
        return false;
    }
}