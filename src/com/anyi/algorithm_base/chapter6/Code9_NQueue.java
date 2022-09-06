package com.anyi.algorithm_base.chapter6;

import java.util.*;

/**
 * n皇后问题
 */
public class Code9_NQueue {
    public static void main(String[] args) {
      
    }
    public static int getNQueueNums(int n){
        int limit = n == 32 ? -1 : (1 << n) -1;
        return getMaxWays(limit,0,0,0);
    }
    public static int queueN(int[] cols,int index){
        // base case
        if(index == cols.length){
            return 1;
        }
        // 遍历当前行的所有节点
        int res = 0;
        for(int j = 0 ;j < cols.length;j++){
            if(isVaild(cols,j,index)){
                cols[index] = j;
                res += queueN(cols,index +1);
            }
        }
        return res;
    }
    // 判断当前行有哪些节点被放置了，判断前
    public static boolean isVaild(int[] cols,int j,int index){
        // 遍历
        for(int i = 0 ; i< index; i ++){
            if(cols[i] == j || Math.abs(cols[i] - j ) == Math.abs(index - i)){
                return false;
            }

        }
        return true;
    }
    /**
     * 采用位数优化
     * 三个数字来表示左右限制
     */
    public static int getMaxWays(int limit,int leftLimit, int colLimit,int rightLimit){
        if(limit == colLimit){
            return 1;
        }
        int res = 0;
        // 找出 pos 位置
        int pos = limit &(~(leftLimit | colLimit | rightLimit)); // 所有能放皇后的位置都是1
        int mostRightOne = 0;
        while(pos != 0){
            mostRightOne = pos &(~pos +1); // 拿到右边最后一个 1
            pos -= mostRightOne; // 减掉右边一个 1 放过了
            res += getMaxWays(limit,(leftLimit | mostRightOne) << 1,
                    colLimit | mostRightOne,
                    (rightLimit | mostRightOne) >>>1);
        }
        return res;
    }
}
