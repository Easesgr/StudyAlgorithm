package com.anyi.middle_improvement.chapter3;


import java.util.ArrayList;
import java.util.List;

/**
 * 蛇形打印一个二维矩阵
 */
public class Code2_ZigZagPrintMatrix {
    public static void main(String[] args) {
        zigZagPrintMatrix(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        });
    }
    /*
        思路：只需要实现一个斜线打印的方法就可以了
     */
    public static List<Integer> zigZagPrintMatrix(int[][] arr){
        /**
         * 遍历的时候，定义连个点，一个点往下走，一个点往右走
         * 走到不能往下走就往右走，另一点走到不能往右走就往下走
         */
        int n = arr.length -1,m = arr[0].length -1;
        int ar = 0,ac=0,br=0,bc=0; // 两个点都从0，0出发
        List<Integer> res = new ArrayList<>();
        Integer[] integers = res.toArray(new Integer[0]);
        boolean flag = false;
        while(ac != m +1){
            printZig(arr,flag,res,ar,ac,br,bc);
            ac = ar == n ? ac + 1:ac;
            ar = ar == n ? ar : ar + 1;
            br = bc == m ? br + 1:br;
            bc = bc == m ? bc: bc +1;
            flag =!flag;
        }
        return res;
    }
    // 给我两个点的横纵坐标
    public static void printZig(int[][] arr, boolean flag, List<Integer> res, int ar, int ac, int br, int bc){
        if(flag){
            while (bc >= ac && br <= ar){
                res.add(arr[br++][bc--]); // 行往下走，列往左走
            }
        }else{
            while (ac <= bc && ar >= br){
                res.add(arr[ar--][ac++]); // 行往下走，列往左走
            }
        }

    }
}
