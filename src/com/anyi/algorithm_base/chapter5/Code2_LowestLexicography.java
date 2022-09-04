package com.anyi.algorithm_base.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一组序列，组成一个新的序列，求出最小序列
 */
public class Code2_LowestLexicography {
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1); // 降序排列
        }
    }
    public static String lowestLexicography(String[] strs){ // 降序排列后，直接拼接返回
        Arrays.sort(strs,new MyComparator());
        String  res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
