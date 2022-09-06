package com.anyi.base_improvement.chapter3;

import java.util.Stack;

/**
 * 单调栈,解决这样一个问题，就是给你一个数组，找到每个数左右两遍第一个大于自己的数
 */
public class Code2_MonotonousStack {
    public static void main(String[] args) {
        int[][] ints = monotonousStack(new int[]{3, 2, 5, 6, 4, 7});

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
