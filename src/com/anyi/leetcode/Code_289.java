package com.anyi.leetcode;

public class Code_289 {
    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0},
        });
    }
    public static void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] ans = new int[n][m];
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        // 遍历当前数组来实现
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 遍历每个方向来判断
                int liveNum = 0;
                for(int[] dir : dirs){
                    int x = i + dir[0],y = j + dir[1]; //
                    // 判断是否越界
                    if(x < 0 || x >= n || y < 0 || y >= m){
                        continue;
                    }else{
                        if(board[x][y] == 1){
                            liveNum ++;
                        }
                    }
                }
                // 根据生存数量判断
                if(liveNum == 2 && board[i][j] == 1){
                    ans[i][j] = 1;
                }else if(liveNum == 3){
                    ans[i][j] = 1;
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m ;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}
