package com.anyi.algorithm_base.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一组字符串的全排列，不能出现重复的
 */
public class Code3_PrintFullArrangement {
    public static void main(String[] args) {
        List<String> abc = printFullArrangement("abc");
    }
    /*
        从左往右尝试
     */
    public static List<String> printFullArrangement(String str){
        char[] strs = str.toCharArray();
        List<String> res = new ArrayList<>();
        fullArrangement(strs,0,res);
        return res;
    }
    public static void fullArrangement(char[] strs,int index,List<String> res){
        // base case
        if(index == strs.length){
            res.add(new String(strs));
        }
        // 考虑后一个是否可以加入，加入前是否重复了
        boolean[] isCheck = new boolean[26];// 判断是否重复选择过
        // 遍历后 n- index 个数，都可以放在当前位置
        for (int i = index; i < strs.length; i++) {
            if(!isCheck[strs[index] - 'a']){ // 当前这个数是不是已经被选择过
                isCheck[strs[index] - 'a'] = true; // 注册
                swap(strs,i ,index);
                fullArrangement(strs,index + 1,res);
                swap(strs,i,index);
            }
            isCheck = new boolean[26];
        }
    }
    public static void swap(char[] strs,int i ,int j){
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}
