package com.anyi.algorithm_base.chapter6;

/*
    给定一个价值数组values和重量数组weights两个数组，一个bag整数，表示可以装的最大重量
    请问可以装的最大价值
 */
public class Code7_Knapsack {
    public static int findMaxValue(int[] values,int[] weights,int bag){
        return getMaxValue(values,weights,0,0,bag);
    }
    public static int getMaxValue(int[] values,int[] weights,int i,int weight,int bag){
        if(weight > bag ){ // base case 基本情况
            return 0;
        }
        // 两种选择，可以不要当前中量
        return Math.max( // 返回较大的一个
                getMaxValue(values,weights,i + 1,weight,bag), // 不要当前包裹。重量不加，价值也不加
                values[i] + getMaxValue(values,weights,i + 1,weight + weights[i],bag)); // 要当前包裹，价值加，重量也加
    }
}
