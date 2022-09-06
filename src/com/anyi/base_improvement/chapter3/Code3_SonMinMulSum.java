package com.anyi.base_improvement.chapter3;

import java.util.Stack;

/**
 * 假设有一个指标 A 子数组的和 * 子数组的最小值，求出指标A的最大值
 */
public class Code3_SonMinMulSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 4, 7};
        int[][] ints = monotonousStack(arr);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < ints.length; i++){
            // 行就是当前数组对应的坐标
            max = Math.max(max,getMinMulSum(arr,ints[i][0],ints[i][1],i));
        }
        System.out.println(max);
    }
    public static int getMinMulSum(int[] arr, int left ,int right,int min){
        left = left == -1? min:left;
        if(left == -1 && right == -1){
            return arr[min] *arr[min];
        }
        int sum = 0;
        for (int i = left ; i<= right ; i++){
            sum +=arr[i];
        }
        return sum * arr[min];
    }
    /**
     * 这里的arr都是不相等的数
     * 思路: 首先加入一个数，之前判断栈是否为空，不是空判断栈顶元素是否是小于自己
     *      如果小于自己，就让它出栈，它右边第一个大于它的数就是要加入的数
     *      它下面压着的那个数就是左边第一个大于它的数，一个单调栈问题
     */
    public static int[][] monotonousStack(int[] arr){ // 返回二维数组中保存每个数左右大于自己第一个数的下标
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>(); // 准备一个栈
        for(int i = 0 ; i < arr.length; i++){ // 遍历数组
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                Integer pop = stack.pop();
                if(stack.isEmpty()){
                    res[pop][0] = -1;
                }else {
                    res[pop][0] = stack.peek();
                }
                res[pop][1] = i;
            }
            stack.push(i);
        }
        int pre = -1;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            res[pop][0] = pre;
            pre = pop;
            res[pop][1] = stack.isEmpty() ? -1:stack.peek();
        }
        return res;
    }
}
