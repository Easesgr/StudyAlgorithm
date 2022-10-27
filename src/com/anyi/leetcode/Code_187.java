package com.anyi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Code_187 {
    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAA");
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        // 采用hash表，将所有10字段的都统计一下
        int l = 10;
        int n = s.length();
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < n - l + 1; i++){
            String temp = s.substring(i,i + l);
            map.put(temp,map.getOrDefault(temp,0) +1);
            if(map.get(temp) == 2){
                ans.add(temp);
            }
        }
        return ans;
    }
}