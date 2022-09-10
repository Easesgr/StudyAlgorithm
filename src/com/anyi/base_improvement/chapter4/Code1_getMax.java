package com.anyi.base_improvement.chapter4;

/**
 * 不采用比较的方法，完成比较两个数的大小
 */
public class Code1_getMax {
    public static void main(String[] args) {
            System.out.println(-(-2147483648));
    }
    // num 必须是 1 或者 0
    public static int flip(int num){
        return num ^ 1;
    }
    // 如果 num > 0 返回 1 ，如果 num < 0 返回 0
    public static int sign(int num){
        return flip(num >> 31 & 1); // 取出符号位
    }
    // 当前只支持 两个正数
    public static int getMax(int a, int b){
        int c = a-b;
        int scA = sign(c);
        int scB = flip(scA);
        return scA * a + scB * b;
    }
    // 改进版支持所有数
    public static int getMaxUp(int a,int b){
        // 首先判断两个数是同符号还是不同符号
        int scA = sign(a);
        int scB = sign(b);
        int scC = sign(a - b); // 两个数的差
        int difSab = scB ^ scA; // 1 ^ 0 = 1  1 ^ 1 = 0  0 ^ 0 =0
        int sameSab = flip(difSab);
        //  + 两边的条件互斥，这样的话两个条件中成立一个，都可以返回a ，如果都不成立，则返回b，取反即可
        int returnA = scA * difSab + sameSab * scC; // a b 不同符号，并且a > 0 返回a  | a b 同符号，a > b 返回a
        int returnB = flip(returnA);
        return returnA * a + returnB *b;
    }
}
