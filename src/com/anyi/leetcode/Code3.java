package com.anyi.leetcode;

/**
 * 给你一个n,搜索二叉树的个数
 */
class Code3 {
    public static void main(String[] args) {
        numTrees(3);
    }
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

