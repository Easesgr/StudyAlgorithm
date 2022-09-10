package com.anyi.base_improvement.chapter4;

/**
 * 判断一个数是不是2的幂
 * 判断一个数是不是4的幂
 */
public class Code2_Power {
    public static void main(String[] args) {
        boolean power = is4Power(4);
        System.out.println(power);
    }
    public static boolean is2Power(int num){
        // 当前数与上当前数减1 就说明是2的幂
        /*
            00001000  =  8
            00000111  =  7
         */
        return (num &(num -1)) == 0;
    }
    public static boolean is4Power(int num){
        /*
           00000100 -> 4  -> 4
           00001000 -> 8  -> 0
           00010000 -> 16 -> 16
         */
                                              // 01010101
        return (num & (num -1)) == 0 && (num &(0x55555555)) == num;
    }
}
