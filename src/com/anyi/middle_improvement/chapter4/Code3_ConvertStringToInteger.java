package com.anyi.middle_improvement.chapter4;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

/**
 * 给你一个字符串，将当前字符串转换成整除，如果不能转换就返回-1
 */
public class Code3_ConvertStringToInteger {
    public static void main(String[] args) {

        int i = convertStringToInteger("-2147483648");
        System.out.println(i);
    }
    public static int convertStringToInteger(String s){
        /*
            思路：先写一个函数判断当前字符串能不能转换成数字
                如果可以转换成数字，我们这里采用一个 负数来相加，因为负数的范围比正数范围大一
         */
        if(s.length() == 0){
            return -1;
        }
        char[] str = s.toCharArray();
        boolean neg = str[0] == '-'; // 判断是不是一个负数
        int minCur = Integer.MIN_VALUE / 10;
        int minSurplus = Integer.MIN_VALUE %10;
        int ans = 0;
        if (isValid(str)){

            for(int i = neg ?1:0; i < str.length; i++){
                // 判断一个数
                int cur ='0' - str[i];
                if(ans < minCur ||(ans ==minCur && cur < minSurplus)){
                    return -1;
                }
                ans = ans * 10 + cur;
            }
            // 判断一下
            if(!neg && ans == Integer.MIN_VALUE){
                return -1;
            }
        }else{
            return -1;
        }
        return neg ? ans: -ans;
    }
    public static boolean isValid(char[] str){
        /**
         * 分析条件 ：当前数的开头，只能是 “-” 或者是数字
         *          当前数如果以0开头，后面必须没有数
         *          如果以“-” 开头，后面的数不能是0
         *          每一个数都必须是数字
         */
        if(str[0] != '-'&& (str[0] < '0' || str[0] > '9')){ // 只要第一个-或者 0-9直接返回
            return false;
        }
        if(str[0] == '-' && str[1] == '0'){ // 如果是-开头，后面第一个数肯定不能是0
            return false;
        }
        if (str[0] == '0' && str.length > 1){ // 如果开头是0，后面必须没有数字了
            return false;
        }
        for(int i = str[0] == '-'?1:0; i < str.length; i++){ // 判断普遍数字
            if(str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true; // 都没问题返回true
    }
}
