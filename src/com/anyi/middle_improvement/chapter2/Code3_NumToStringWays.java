package com.anyi.middle_improvement.chapter2;

/**
 * 给你一个数字序列，请问可以转成多少种字符串
 * 1对应a 2对应b ... 26对应z
 */
public class Code3_NumToStringWays {

    public static int numToStringWays(String str){
        char[] chars = str.toCharArray();
        // 递归尝试
        return getWay(chars,0);
    }

    public static int getWay(char[] strs ,int index){
        if(index == strs.length){ // 到达最后一个后，说明这是一种转换结果
            return 1;
        }
        if(strs[index] == '0'){
            return 0;
        }
        int res = 0;
        // 其他种可能，如果等于0，单个数字总可以转换
        res += getWay(strs,index +1);
        // 当前index+1小于最后一个
        if(index + 1 < strs.length){
            if (strs[index] - '0' * 10 + strs[index +1] - '0' < 27){
                res += getWay(strs,index +2);
            }
        }
        return res;
    }
}
