package com.anyi.leetcode;

import java.util.Arrays;

class Code4 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] arr = new char[s1.length() + s2.length()];
        for(int i = 0 ; i < s1.length(); i++){
            arr[i] = s1.charAt(i);
        }
        for(int i = 0; i < s2.length(); i++){
            arr[i +s1.length()] = s2.charAt(i);
        }
        char[] arr1 = s3.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        return new String(arr).equals(new String(arr1));
    }
}