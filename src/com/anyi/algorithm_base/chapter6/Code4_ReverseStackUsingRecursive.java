package com.anyi.algorithm_base.chapter6;

import java.util.Stack;

/**
 * 利用递归来实现栈的逆转
 */
public class Code4_ReverseStackUsingRecursive {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverseStack(stack);
        System.out.println();
    }
    /*
        获取到栈底元素后，如果栈还没有空，就继续拿最后一个元素，最后一个元素拿出来的时候，将该数压栈
        然后退栈，让取出来的元素压栈，完成反转
     */
    public static void reverseStack(Stack<Integer> stack){
        int endNum = getEndNum(stack);
        if(stack.isEmpty()){ // 到达最后一个让当前获得元素出栈
            stack.push(endNum);
            return;
        }
        reverseStack(stack);
        stack.push(endNum);
    }

    /*
        每次获取栈低元素，并且将原来的数压栈
     */
    public static int getEndNum(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){ // base case
            return pop;
        }
        int fast = getEndNum(stack);
        stack.push(pop); // 最后一个数往回走的时候，将原来拿出来的节点直接进栈
        return  fast;
    }
}
