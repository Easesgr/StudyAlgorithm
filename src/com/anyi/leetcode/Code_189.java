package com.anyi.leetcode;

import java.util.Stack;

public class Code_189 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public static void rotate(int[] nums, int k) {
        // 准备两个栈，先让所有的元素进入第一个栈，然后弹出k个进另一个栈，将另一个栈倒出，然后让剩下的进取
        k = k % nums.length;
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        for(int i = 0; i<nums.length; i++){
            first.push(nums[i]);
        }
        for(int i = 0; i<k ;i++){
            second.push(first.pop());
        }
        int index = 0;
        while(!second.isEmpty()){
            nums[index++] = second.pop();
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        while(!second.isEmpty()){
            nums[index++] = second.pop();
        }
    }
}
