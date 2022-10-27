package com.anyi.leetcode;

import java.util.Stack;

class Code_1700 {
    public static void main(String[] args) {
        countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1});
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        // 因为所有人都在一个循环队列中，所以他们都可能会拿到，只需要计算爱好人数即可
        Stack<Integer> stack = new Stack();
        for(int i = sandwiches.length - 1; i >= 0; i--){
            stack.push(sandwiches[i]);
        }
        // 统计分别的喜好人数
        int love0 = 0, love1 = 0;
        for(int i = 0; i < students.length; i ++){
            love0 = love0 + (students[i] == 0? 1:0);
            love1 = love1 + (students[i] == 1? 1:0);
        }
        while(!stack.isEmpty()){
            if(love0 > 0 || love1 > 0){
                if(love0 > 0 && stack.peek() == 0){
                    stack.pop();
                    love0 --;
                }else if(love1 > 0 && stack.peek() == 1){
                    stack.pop();
                    love1--;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return love0 + love1;
    }
}