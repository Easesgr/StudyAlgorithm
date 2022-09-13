package com.anyi.middle_improvement.chapter2;


/**
 * 给你一组括号序列，求出序列中，有效的最大括号数
 */
public class Code4_ParenthesesDeep {
    public static int parenthesesDeep(String s){
        if (s.length() < 2){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        // 遍历一遍list 采用动态规划
        int maxDeep = 0;
        for(int i = 0 ; i < str.length; i++){
            if(str[i] == '('){
                dp[i] = 0;
            }else{
                int pre =i - dp[i -1] -1;
                // 如果是右括号，那么可能和他匹配的左括号就时前一个括号的有效值往前推n个
                if( pre >= 0 &&str[pre] == '(') {
                    dp[i] = dp[i-1] + 2 // 当前括号匹配，加上前面已经匹配过的值
                            + (pre-1 >= 0 ? dp[pre-1] : 0); // 如果 与当前括号匹配的前一段还有有效值，前一段有效值
                }
                maxDeep = Math.max(dp[i],maxDeep);
            }
        }
        return maxDeep;
    }
}
