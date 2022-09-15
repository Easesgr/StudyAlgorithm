package com.anyi.middle_improvement.chapter3;

/**
 * 将一个矩阵中的元素旋转90度返回
 */
public class Code3_RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        });
    }
    public static void RotateMatrix(int[][] arr){
        /**
         * 只需要两个对角的点，a(x1,y1) b(x2,y2),每次让外面的环交换
         */
        int x1 = 0,y1 =0,x2 = arr.length-1,y2 = arr.length -1; // 正方形
        while(x1 <= x2){
            for(int i = 0; i < x2 - x1; i++){
                // 交换四个值
                int temp  = arr[x1+i][y2];
                arr[x1+i][y2] = arr[x1][y1 + i];
                arr[x1][y1 + i] = arr[x2-i][y1];
                arr[x2-i][y1] =  arr[x2][y2 -i];
                arr[x2][y2 -i] = temp;
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
    }
}
