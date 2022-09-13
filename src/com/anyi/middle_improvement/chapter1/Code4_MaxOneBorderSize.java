package com.anyi.middle_improvement.chapter1;

/**
 * 给你一个非0即1的矩阵，找出最大边长的正方形
 * 思路：如果直接遍历的话，每次进入一个点都需要遍历它的四个方向，这样时间复杂度就是n**4
 *      我们可以提前生成两组处理好的每个点往右有多少个连续的1，往下有多少个连续的1
 *      只需要O(n**3)就可以解决问题
 */
public class Code4_MaxOneBorderSize {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1},
                {1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1},
                {1,0,1,0,0,1,1,1},
                {0,1,1,1,1,0,1,1}
        };
        int i = maxOneBorderSize(arr);
        System.out.println(i);
    }
    public static int maxOneBorderSize(int[][] matrix){
        // 申请两个辅助数组
        int n = matrix.length, m = matrix[0].length;
        int[][] rightOne = new int[n][m]; // 向右有多少个连续的 1
        int[][] downOne = new int[n][m]; // 向下有多少个连续的 1
        // 赋值右矩阵
        for(int i = 0 ; i < n; i++){
            for(int j = m-1; j >= 0; j--){ // 从右往左动态规划
                // 如果有 j-1就是j-1+当前数是否等于1，如果都没有就只有数的1
                rightOne[i][j] = j + 1 < m ? (matrix[i][j] == 1?rightOne[i][j+1]+1:0):(matrix[i][j] == 1?1:0);
            }
        }
        // 赋值向下的矩阵
        for(int j =0; j < m ; j ++){
            for (int i = n-1; i >= 0; i--){
                downOne[i][j] = i + 1 < n ?(matrix[i][j] == 1? downOne[i+1][j] +1:0):(matrix[i][j] == 1?1:0);
            }
        }
        // 遍历整个数组，每次位置去两个集合中，小的那一作为最小边
        int maxBorder = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    int border = Math.min(rightOne[i][j] ,downOne[i][j]);
                    while(border > 1){
                        if(i + border -1 < n && j + border-1 < m &&
                                rightOne[i + border -1][j] >= border && downOne[i][j + border-1] >=border ){
                            maxBorder = Math.max(maxBorder,border);
                        }
                        border --;
                    }
                }

            }
        }
        return maxBorder;
    }
}
