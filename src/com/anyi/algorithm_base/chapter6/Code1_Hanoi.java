package com.anyi.algorithm_base.chapter6;

/**
 * 汉罗塔问题 暴力递归
 */
public class Code1_Hanoi {
    public static void main(String[] args) {
        hanoi();
    }
    public static void hanoi(){
        int n = 5;
        f(n,"左","中","右");
    }
    public static void f(int n , String start,String others,String end){
        if(n == 1){ // base case 最后只剩一个的时候，直接从start搬到end去
            System.out.println(1 + "从"+start + "移动到" + end);
            return;
        }
        // 先将 start n-1 个移动到 others上
        f(n-1,start,end,others); // 找到递归的可能性
        // 从start将最后一个移动到end上
        System.out.println(n + "从"+start + "移动到" + end);
        // 再将n-1一个从others移动到end上
        f(n-1,others,start,end);
    }
}
