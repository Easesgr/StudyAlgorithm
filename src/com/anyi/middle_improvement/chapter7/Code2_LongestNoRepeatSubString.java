package com.anyi.middle_improvement.chapter7;

import java.util.Arrays;

/**
 * 给你一个字符串，找出最长且不重复的字符串，返回其长度
 */
public class Code2_LongestNoRepeatSubString {
    public static void main(String[] args) {
        int absnacsefgh = longestNoRepeatSubString("absnacsefgh");
        System.out.println(absnacsefgh);
    }
    public static int longestNoRepeatSubString(String str){
        /**
         * 思路: 找到与当前数相等的前一个数，这个长度，和前一个数可以扩展到的最大位置比较，取小的就是当前位置的最长子串
         */
        if(str == null || str.equals("")){
            return 0;
        }
        int[] map = new int[256]; //表示所有的字符
        Arrays.fill(map,-1);
        int cur = 0;
        int pre = -1;
        int len = 0;
        char[] words = str.toCharArray();
        for (int i = 0 ; i < words.length; i++){
            pre = Math.max(pre,map[words[i]]); // 看看是当前可以扩展的左边更后，还是前一个节点可以拓展的节点更后
            cur = i - pre; // 当前节点可以拓展到的最大值
            len = Math.max(len,cur);
            map[words[i]] = i; // 记录当前字符的左边
        }
        return len;
    }
}
