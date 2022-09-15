package com.anyi.middle_improvement.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转打印数组
 */
public class Code4_PrintMatrixSpiralOrder {
    public static void main(String[] args) {
        printMatrixSpiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        });
    }
    /*
        思路：给一个对角线，
     */
    static List<Integer> res= new ArrayList<>();
    public static void printMatrixSpiralOrder(int[][] arr){
        // 创建对角线的两个点
        int ar = 0,ac =0,br=arr.length -1,bc = arr[0].length-1;
        while(ar <= br && ac <= bc){
            printMatrixSpiralOrder(arr,ar++,ac++,br--,bc--);
        }
    }

    private static void printMatrixSpiralOrder(int[][] arr, int ar, int ac, int br, int bc) {
        if(ar == br){
            //如果同行了 从左往右打印
            for (int i = ac; i <= bc; i++){
                res.add(arr[ar][i]);
            }
        }else if (ac == bc){//如果同列了
            for(int i = ar; i<= br; i++){
                res.add(arr[i][ac]);
            }
        }else{
            // 不同行不同列
            int curC = ac;
            int curR = ar;
            // 往右的
            while(curC != bc){
                res.add(arr[ar][curC++]);
            }
            // 往下的
            while(curR != br){
                res.add(arr[curR++][bc]); // 向下走
            }

            while(curC != ac){
                res.add(arr[br][curC--]);
            }

            while(curR != ar){
                res.add(arr[curR--][ac]);
            }
        }
    }
}
