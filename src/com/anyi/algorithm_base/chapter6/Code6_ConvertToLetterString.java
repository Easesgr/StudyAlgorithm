package com.anyi.algorithm_base.chapter6;

import java.security.PublicKey;

/**
 * 数字1对应A,数字2对应B,数字3对应C，
 * 讲一个字符串 “111” 转化为 ”AAA“ "KA" 和 ”AK“
 * 给定一个字符串 ,返回有多少种组合
 */
public class Code6_ConvertToLetterString {
    public static void main(String[] args) {
        convertToLetterString("111");
    }
    public static int convertToLetterString(String str){
        char[] strs = str.toCharArray();
        int ways = findWays(strs, 0);
        return ways;
    }
    public static int findWays(char[] strs, int index){
        if (index == strs.length){ // 如果走到这一步，说明全部否符合
            return 1;
        }
        /*
            判断：走到任意位置，前面是已经排好的，当前值可以递归往下有以下几种情况：
            1 ： 如果遇到 0 ,不可能能转换，没有对应的值 直接返回
            2 : 如果遇到 1-2, 总是有一条可以往下走的路 index + 1;
                其次，如果下一个数是 1-6,可以转换 可以往下递归 index + 2;
            3 : 如果是 3-9，只能当前值往下递归 index + 1;
         */
        int res = 0;
        if (strs[index] == '0'){ // 第一种情况
            return 0;
        }
        if (strs[index] <= '2'){ // 第二种情况
            res += findWays(strs,index + 1);
            if(index + 1 < strs.length && strs[index + 1] >= '0' &&   strs[index + 1] <= '6'){
                res +=findWays(strs,index + 2);
            }
        }
        if (strs[index] > '2'){
            res +=findWays(strs,index + 1);
        }
        return res;
    }
}
