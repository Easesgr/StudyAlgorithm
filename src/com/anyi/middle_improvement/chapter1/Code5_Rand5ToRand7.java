package com.anyi.middle_improvement.chapter1;

/*
  * 给你一个随机生成 1-5的函数，怎么等概率随机生成 1-7
  * 思路；将随机函数转换成一个0或1生成器，然后看需要表示的需要几个位，根据需要的位数随机获取01
 */
public class Code5_Rand5ToRand7 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(rand1And7());
        }
    }
    public static int rand1And5(){ // 生成1-5的随机数返回
        return (int) (Math.random() * 5) +1;
    }
    public static int rand0And1(){
        int res = 0;
        do{
            res = rand1And5();
        }while(res == 3);
        return res < 3 ? 0:1;
    }
    public static int rand1And7(){
        int res =0;
        do{
            res = (rand0And1() <<2) + (rand0And1() <<1) + rand0And1();
        }while(res == 7);
        return res  + 1;
    }
}
