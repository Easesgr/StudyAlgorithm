package com.anyi.middle_improvement.chapter2;

/**
 * 先手和后手吃草
 * 给你n颗草，每次只能吃4的幂次方的草，谁先把草吃完谁输
 */
public class Code6_Eat {
    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            if (print(i) != eat(i)){
                System.out.println("error");
            }
        }

    }
    public static String eat(int n){
        if(n < 5){
            return (n ==0 || n==2)?"后手":"先手";
        }
        int base =1;
        while (base <= n){ // 只要小于n 那么就继续试吃4的更多次方的草，能不能赢
            if(eat(n - base).equals("后手")){
                return "先手";
            }
            if (base > n / 4){
                break;
            }
            base*=4;
        }
        return "后手";
    }
    public static String  print(int n){
        if (n % 5 ==0 || n %5 == 2){
            return "后手";
        }else{
            return "先手";
        }
    }
}
