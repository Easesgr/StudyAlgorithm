package com.anyi.middle_improvement.chapter7;

/**
 * 给你两个字符串，将一个字符串变成另一个字符串，需要付出多少代价
 * 通过 替换 rc 删除 dc 添加 ic 的代价，求出最小代价
 */
public class Code3_EditCost {
    public static void main(String[] args) {
        int i = minCost("abcd", "efgh", 1, 2, 3);
        System.out.println(i);
    }
    /**
     * 动态规划，讲一个字符串，转换成另一个字符串
     */
    public static int minCost(String str1 ,String str2,int rc,int dc,int ic){
        int row = str1.length(),col =str2.length();
        if(col != row){
            return -1; // 没法转换
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = new int[row + 1][col + 1];
        /*
         横坐标表示想把s1转换成s2包含col个字符，需要代价
         纵坐标表示想把s2转换成s1包含row个字符串，需要的代价
         */
        for(int i = 1 ; i <= col;i ++){ // 将s1的空串变成s2的第i个，只能一直添加
            dp[0][i] = i * ic; // 全部都是插入代价
        }
        for(int i = 0 ; i <= row; i++){ // 将s1 不是空串变成s2是空串，只要一直删除就可以
            dp[i][0] = i *dc;
        }
        // 普遍位置
        for(int i = 1; i <=row; i++){
            for(int j = 1; j <= col; j++){
                // 如果当前 i和j字符相同
                if(chs1[i -1] == chs2[j -1]){ // 就是上一个到达上个字符串的代价
                    dp[i][j] = dp[i-1][j -1];
                }else{ // 不相等，就可以用另个字符串代替实现
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                // 尝试使用添加和删除来实现，看谁的代价小
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + ic); // 通过s2加上一个字符串来实现
                dp[i][j] = Math.min(dp[i][j],dp[i -1][j] +dc); // 通过s1删除一个字符串来实现
            }
        }
        return dp[row][col];
    }
}
