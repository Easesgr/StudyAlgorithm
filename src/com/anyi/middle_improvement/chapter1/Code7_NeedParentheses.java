package com.anyi.middle_improvement.chapter1;

/**
 *  给你一组括号序列,需要添加多少个括号，可以使括号是完整的
 */
public class Code7_NeedParentheses {
    public static boolean needParentheses(String str){
        int conut = 0;
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == '('){
                conut ++;
            }else{
                conut --;
            }
        }
        return conut == 0 ;
    }
}
