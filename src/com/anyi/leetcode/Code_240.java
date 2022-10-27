package com.anyi.leetcode;

public class Code_240 {
    public static void main(String[] args) {
        searchMatrix(new int[][]{
                {3},
                {4}
        },4);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 找对角线第一个大于目标值的数，扫描该行和列，一定能找到，没有找到就是没有
        int n = matrix.length - 1, m = matrix[0].length -1;
        int maxLen = Math.min(n,m);
        int i = 0,j = 0;
        while(i <= n && j <= m && matrix[i][j] < target){
            if(i < maxLen && j < maxLen){
                i++;
                j++;
            }else if(j < m){
                j++;
            }else if(i < n){
                i++;
            }else{
                return false;
            }
        }
        // 遍历行和列
        if(i <= n && j <= m){
            for(int row = 0; row <= n; row++){
                if(matrix[row][j] == target){
                    return true;
                }
            }
            for(int col = 0; col <= m ; col++){
                if(matrix[i][col] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
