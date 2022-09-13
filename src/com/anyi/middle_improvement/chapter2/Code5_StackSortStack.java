package com.anyi.middle_improvement.chapter2;

import java.util.Stack;

/**
 * 给你一个无序的栈，你可以使用一个辅助栈，将无序变成从大到小的顺序
 */
public class Code5_StackSortStack {
    public static Stack<Integer> stackSortStack(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<>();
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            if(helpStack.isEmpty() || pop < stack.peek()){
                helpStack.push(pop);
            }else {
                while(helpStack.peek() < pop){
                    stack.push(helpStack.pop());
                }
                helpStack.push(pop);
            }
        }
        while (!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
        return stack;
    }
}
