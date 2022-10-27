package com.anyi.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Code_1790 {
    public static void main(String[] args) {
        areAlmostEqual("bank","kanb");
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        // 直接进行排序判断是否相等
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(!( new String(ch1)).equals( new String(ch2))){
            return false;
        }
        int flag = 0;
        for(int i = 0 ; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                flag++;
                if(flag > 2){
                    return false;
                }
            }
        }
        return true;
    }
}