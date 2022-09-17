package com.anyi.leetcode;

import java.util.Arrays;

public class Code_172 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            int i1 = trailingZeroes(i);
            System.out.println(i + "   " + i1);
        }
    }
    public static int trailingZeroes(int n) {
        /* 因为如果要有1个0，那么必须要有一个2的倍数，一个5的倍数，
        因为2的倍数的数，肯定比5的倍数的数多，所以我们只要求出有多少个5的倍数就知道能有多少个0了
        */
        int ans = 0;
        while( n !=0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
