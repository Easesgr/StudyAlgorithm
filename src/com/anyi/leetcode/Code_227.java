package com.anyi.leetcode;

import java.util.Stack;

public class Code_227 {
    public static void main(String[] args) {
        int calculate = calculate("42");
        System.out.println(calculate);
    }
    public static int calculate(String s) {
        /*
         准备一个栈，数字直接进去，如果数字前面是乘除，先把进入数和前一个数做完乘除,然后压入，
         如果，最后计算栈中的加减
         */
        s = s.replaceAll("\\s+","");
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(int i = 0 ; i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                if(!stack.isEmpty() && (stack.peek() == '/' || stack.peek() == '*')){ // 栈不为空，最上面字符是乘除，将前一个两个数弹出
                    char symbol = stack.pop(); // 符号位
                    char forntNum = stack.pop(); // 数字位
                    if(symbol == '/'){
                        stack.push((char) (((forntNum - '0') / (str[i] - '0')) + '0'));
                    }else{
                        stack.push((char) ((forntNum - '0') * (str[i] - '0') +'0'));
                    }
                }else{
                    stack.push(str[i]);
                }
            }else{
                stack.push(str[i]);
            }
        }
        // 乘除计算完毕
        if(stack.size() >= 2){
            char up = stack.pop();
            char symbol = stack.pop();
            if(!stack.isEmpty()){
                char down = stack.pop();
                if(symbol == '-'){
                    stack.push((char) ((down - '0') - (up - '0') + '0'));
                }else if(symbol == '+'){
                    stack.push((char) ((down - '0') + (up - '0') + '0'));
                }
            }else{
                stack.push((char)((symbol - '0') * 10 + (up - '0') + '0'));
            }
        }
        return stack.pop() -'0';
    }
}
