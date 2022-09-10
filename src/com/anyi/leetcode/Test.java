package com.anyi.leetcode;

import java.util.*;

/**
 * 测试方法
 */
public class Test {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        int random = randomizedSet.getRandom();
        System.out.println(random);
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        randomizedSet.getRandom();
        List<List<Integer>> res = new ArrayList<>();
        String tes = "191u9";
        char[] chars = tes.toCharArray();
        Arrays.sort(chars);
        List<int[]> list =new ArrayList<>();
        int[][] ints = list.toArray(new int[list.size()][]);
    }
}
