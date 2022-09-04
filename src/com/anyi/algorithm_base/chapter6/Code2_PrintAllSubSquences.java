package com.anyi.algorithm_base.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 打印一个字符串的所有子序列
 */
public class Code2_PrintAllSubSquences {
    /**
     * 思路 ： 所有子串，我们递归到哪一个，都只需要烤炉，当前下一个字母是要还是不要
     *        分要和不要两种进入递归
     */
    public static void main(String[] args) {
        printAllSubSquences("abc");
    }
    public static void printAllSubSquences(String str){
        char[] strs = str.toCharArray();
        List<Character> res = new ArrayList<>();
        printAllSquences2(strs,0);
    }
    public static void printAllSquences(char[] str,int index,List<Character> res){
        if(index == str.length){ // 基础条件
            printList(res);
            return;
        }
        // 两种情况，我们是加入当前index对应的字符串还是不加入
        List<Character> inKeep = copyList(res);
        inKeep.add(str[index]);
        printAllSquences(str,index + 1,inKeep); // 从左往右尝试，两种尝试方法
        List<Character> noInclude = copyList(res);
        printAllSquences(str,index +1,noInclude);
    }
    /*
     可以采用一种更省空间的
     */
    public static void printAllSquences2(char[] str,int index){
        if(index == str.length){ // 基础条件
            System.out.println(String.valueOf(str));
            return;
        }
        // 两种情况，我们是加入当前index对应的字符串还是不加入
        printAllSquences2(str,index + 1);
        char temp = str[index];
        str[index]= 0;
        printAllSquences2(str,index + 1);
        str[index] = temp;
    }

    public static void printList(List<Character> list){ // 打印列表
        //
        String res = "";
        for (Character character : list) {
            res +=character;
        }
        System.out.println(res);
    }
    public static List<Character> copyList(List<Character> res){ // 复制列表
        List<Character> newList = new ArrayList<>();
        newList.addAll(res);
        return newList;
    }
}
