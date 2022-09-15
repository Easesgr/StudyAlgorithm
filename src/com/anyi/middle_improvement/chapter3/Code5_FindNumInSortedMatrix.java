package com.anyi.middle_improvement.chapter3;

/**
 * 给你一个二维矩阵，行是升序，列也是升序，从二维矩阵中查找一个数是否存在
 */
public class Code5_FindNumInSortedMatrix {
    public boolean findNumInSortedMatrix(int[][] arr,int target){
        // 从最右边往下找，找到大于target的，然后往左找，有没有相等的
        int n = arr.length -1 ,m =arr[0].length -1;
        for (int i = 0; i <= n ;i++){
            if(target < arr[i][m]){
                for(int j = m; j >= 0;j--){
                    if(arr[i][j] == target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
