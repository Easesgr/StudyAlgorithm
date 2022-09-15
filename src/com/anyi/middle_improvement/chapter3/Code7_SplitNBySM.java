package com.anyi.middle_improvement.chapter3;

/**
 * 初始化 m = "a" s = m
 * 公式1 s = m  s = s + s;
 * 公式2 s = s + m;
 * 最少使用多少步使得字符串的长度到达n
 */
public class Code7_SplitNBySM {
    /**
     * 如果是质数，只能用公式2来搞定
     */
    public static boolean isPrime(int n){
        if (n <= 3) {
            return n > 1;
        }
        for(int i = 2; i < n; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    // 当前这个数由多少个质数相乘
    public static int[] divSumAndCount(int n){
        int sum = 0;
        int count = 0;
        for(int i = 2; i <=n ;i++){
            while(n %i == 0){
                sum+=i;
                count++;
                n /=i;
            }
        }
        return  new int[]{sum,count};
    }
    public static int splitNBySM(int n){
        if(n < 2){
            return 0;
        }
        if(!isPrime(n)){
            return n-1; // 只能用公式2处理
        }
        int[] divSumAndCount = divSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }
}
