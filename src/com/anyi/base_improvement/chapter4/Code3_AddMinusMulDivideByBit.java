package com.anyi.base_improvement.chapter4;

/**
 * 通过 bit 位完成两个数的加减乘除
 * 整个代码不考虑溢出问题
 */
public class Code3_AddMinusMulDivideByBit {
    public static void main(String[] args) {
        int i =bitDivision(10, 2);
        System.out.println(i);
    }
    /*
        思路：一个数异或上另一个数 -> 两个数无进位相加相加
             一个数与上另一个数左移一位 -> 两个数相加的进位结果
        如果进位数字不等于0继续对上一次无进位相加值和进位相加值求 异或和与 << 1
     */
    public static int bitAdd(int a ,int b){
        int sum = 0;
        while(b != 0){
            sum = a ^ b; // 无进位相加
            b = (a & b) << 1; // 进位结果
            a = sum; // 更新a的值
        }
        return sum;
    }
    // 减法，改一下加法
    public static int bitSub(int a,int b){
        return bitAdd(a,swapNegative(b));
    }

    private static int swapNegative(int b) {
        return bitAdd( ~ b, 1); // 一个数取反 + 1 就等于它的相反数
    }
    // 乘法
    public static int bitMul(int a, int b){
        if( b == 0){
           throw new RuntimeException("除数不能为0");
        }
        // 采用 a 左移 b右移的方法
        int res = 0;
        while(b > 0){
            if ((b & 1) == 1){
                res = bitAdd(res,a);
            }
            a =a <<1;
            b = b >>> 1;
        }
        return res;
    }
    // 除法 就是 a 可以减掉多少个b
    public static int bitDivision(int a , int b){ // 不兼容负数
        int res;
        if( a < b){
            return 0;
        }else {
            res = bitDivision(bitSub(a,b),b) + 1;
        }
        return res;
    }
}
