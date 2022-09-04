package com.anyi.algorithm_base.chapter5;

import java.util.Map;

/**
 * n 皇后问题
 */
public class Code7_NQueen {
    public static int nQueue(int n){
        if (n ==1){
            return 1;
        }
        if(n == 2 || n == 3){
            return 0;
        }
        int[] col = new int[n];
        return findNQueen(n,0,col);
    }
    public static int findNQueen(int n ,int index,int[] col){
        if (n == index){
            return 1;
        }
        int res  = 0;
        // 遍历当前列，看看是不是和上面的冲突了
        for (int i = 0; i < n; i++) {
            if(isValid(index,i,col)){
                col[index] = i; // 存入当前行
                res += findNQueen(n,index + 1,col);
            }
        }
        return res;
    }
    public static boolean isValid(int i,int j ,int[] col){
        // 看前面的行是不是有问题
        for (int k = 0; k <i ; k++) {
            if(col[k] == j || Math.abs(col[k] - j) == Math.abs(k - i)){
                return false;
            }
        }
        return true; // 前面的 i 行都没有和当前这个列重合的
    }
}
